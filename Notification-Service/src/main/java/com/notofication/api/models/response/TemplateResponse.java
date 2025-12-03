package com.notofication.api.models.response;

import com.notofication.api.models.entities.Template;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateResponse {
    private String id;
    private String name;

    public TemplateResponse(Template template) {
        this.id = template.getId().toString();
        this.name = template.getName();
    }
}
