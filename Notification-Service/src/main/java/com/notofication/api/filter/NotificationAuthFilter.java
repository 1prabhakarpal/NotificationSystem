package com.notofication.api.filter;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.notofication.api.constants.ApplicationConstants;
import com.notofication.api.models.context.NotificationContext;
import com.notofication.api.models.context.NotificationContextHolder;
import com.notofication.api.utils.CommonUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class NotificationAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (isValidAPI(request.getRequestURI())) {
            String xTenantId = request.getHeader(ApplicationConstants.X_TENANT_ID);
            if (CommonUtils.isEmpty(xTenantId)) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Unauthorized! API Key is required");
            }

            NotificationContextHolder.setContext(new NotificationContext(xTenantId));
        }
        filterChain.doFilter(request, response);

        if (isValidAPI(request.getRequestURI())) {
            NotificationContextHolder.clearContext();
        }
    }

    static boolean isValidAPI(String apiPath) {
        return apiPath.startsWith("/api");
    }

}
