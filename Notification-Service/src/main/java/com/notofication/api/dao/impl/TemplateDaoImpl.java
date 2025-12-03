package com.notofication.api.dao.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.notofication.api.dao.interfaces.TemplateDao;
import com.notofication.api.dao.repositories.TemplateRepository;
import com.notofication.api.models.entities.Template;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
class TemplateDaoImpl implements TemplateDao {
    private final TemplateRepository templateRepository;

    @Override
    public Optional<Template> findByTenantIdAndName(final String tenantId, final String templateName) {
        return templateRepository.findByNameIgnoreCaseAndTenantId(templateName, UUID.fromString(tenantId));
    }

    @Override
    public Template save(final Template template) {
        return templateRepository.save(template);
    }
}
