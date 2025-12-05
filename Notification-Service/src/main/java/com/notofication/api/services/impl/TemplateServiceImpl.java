package com.notofication.api.services.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.notofication.api.constants.ErrorConstants;
import com.notofication.api.dao.interfaces.TemplateDao;
import com.notofication.api.exception.ValidationException;
import com.notofication.api.models.context.NotificationContext;
import com.notofication.api.models.context.NotificationContextHolder;
import com.notofication.api.models.entities.Template;
import com.notofication.api.models.request.CreateTemplateRequest;
import com.notofication.api.models.response.TemplateResponse;
import com.notofication.api.services.interfaces.TemplateService;
import com.notofication.api.utils.CommonUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
class TemplateServiceImpl implements TemplateService {

    private final TemplateDao templateDao;

    @Override
    public TemplateResponse createTemplate(CreateTemplateRequest request) {
        NotificationContext holder = NotificationContextHolder.getContext();
        templateDao.findByTenantIdAndName(holder.tenantId(), request.getName()).ifPresent(template -> {
            throw new ValidationException(HttpStatus.BAD_REQUEST.value(), ErrorConstants.TEMPLATE_ALREADY_EXISTS);
        });

        Template template = Template.builder()
                .id(CommonUtils.generateUUID())
                .name(request.getName())
                .tenantId(UUID.fromString(CommonUtils.getTenantId()))
                .build();
        BeanUtils.copyProperties(request, template);
        template.entityCreated();
        templateDao.save(template);
        return new TemplateResponse(template);
    }

}
