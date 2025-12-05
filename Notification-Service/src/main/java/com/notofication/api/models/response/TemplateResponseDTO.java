package com.notofication.api.models.response;

import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.notofication.api.models.entities.Template;

import lombok.Data;

@Data
public class TemplateResponseDTO {
    private String id;
    private String name;
    private Map<String, String> templateVariables;

    public TemplateResponseDTO(Template template) {
        BeanUtils.copyProperties(template, this);
        setId(template.getId().toString());
    }
}
