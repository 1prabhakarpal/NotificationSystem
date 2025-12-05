package com.notofication.api.dao.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.notofication.api.models.entities.Template;

public interface TemplateDao {

    Optional<Template> findByTenantIdAndName(String tenantId, String templateName);

    Template save(Template template);

    Page<Template> filterTemplate(Example<Template> example, PageRequest pageRequest);

}
