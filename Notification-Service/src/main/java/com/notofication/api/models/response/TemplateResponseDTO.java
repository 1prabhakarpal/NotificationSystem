package com.notofication.api.models.response;

import java.util.Map;

import com.notofication.api.models.entities.Template;

import lombok.Data;

@Data
public class TemplateResponseDTO {
    private String id;
    private String name;
    private Map<String, String> templateVariables;

    public TemplateResponseDTO(Template template) {
        if (template.getId() != null) {
            this.id = template.getId().toString();
        }
        this.name = template.getName();
        this.templateVariables = template.getTemplateVariables();
    }
}
