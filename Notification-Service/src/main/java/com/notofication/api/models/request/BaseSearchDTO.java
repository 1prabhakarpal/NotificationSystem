package com.notofication.api.models.request;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import com.notofication.api.constants.ErrorConstants;
import com.notofication.api.exception.ValidationException;
import com.notofication.api.utils.CommonUtils;

import static java.util.Optional.ofNullable;

import java.lang.reflect.Field;
import java.util.UUID;

import lombok.Data;

@Data
public abstract class BaseSearchDTO<T> {
    private Integer page = 0;
    private Integer size = 10;
    private SortRequest sortRequest;

    public PageRequest buildPageRequest() {
        Sort sort = ofNullable(sortRequest).filter(CommonUtils::isNotEmpty)
                .filter(req -> CommonUtils.isNotEmpty(req.getSortKey()) && CommonUtils.isNotEmpty(req.getSortType()))
                .filter(req -> {
                    try {
                        this.getClass().getDeclaredField(req.getSortKey());
                        return true;
                    } catch (NoSuchFieldException e) {
                        throw new ValidationException(HttpStatus.BAD_REQUEST.value(), ErrorConstants.INVALID_SORT_KEY);
                    }

                }).map(req -> Sort.by(Sort.Direction.fromString(req.getSortType().getValue()), req.getSortKey()))
                .orElse(Sort.by(Sort.Direction.DESC, "createdAt"));
        return PageRequest.of(
                ofNullable(page).orElse(0),
                ofNullable(size).orElse(10),
                sort);
    }

    public Example<T> buildSearch() {
        try {
            Class<T> entityClass = getEntityClass();
            T instance = entityClass.getDeclaredConstructor().newInstance();
            injectTenantId(instance);

            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object fieldValue = field.get(this);
                if (CommonUtils.isNotEmpty(fieldValue)) {
                    Field entityField = getField(entityClass, field.getName());
                    entityField.setAccessible(true);
                    entityField.set(instance, fieldValue);
                }
            }

            ExampleMatcher matcher = ExampleMatcher
                    .matchingAll()
                    .withIgnoreCase()
                    .withIgnoreNullValues();

            return Example.of(instance, matcher);

        } catch (Exception e) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Error while building search");
        }

    }

    private void injectTenantId(final Object instance) {
        try {
            Field field = getField(instance.getClass(), "tenantId");
            field.setAccessible(true);
            field.set(instance, UUID.fromString(CommonUtils.getTenantId()));
        } catch (Exception e) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.value(),
                    ErrorConstants.ERROR_WHILE_SETTING_TENANT_ID + " in Search Builder");
        }
    }

    public abstract Class<T> getEntityClass();

    public Field getField(Class<?> entityClass, String fieldName) {
        Class<?> currentClass = entityClass;
        while (currentClass != null) {
            try {
                return currentClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                currentClass = currentClass.getSuperclass();
            }
        }
        return null;
    }

}
