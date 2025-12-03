package com.notofication.api.dao.interfaces;

import java.util.Optional;

import com.notofication.api.models.entities.Template;

public interface TemplateDao {

    Optional<Template> findByTenantIdAndName(String tenantId, String templateName);

    Template save(Template template);

}
