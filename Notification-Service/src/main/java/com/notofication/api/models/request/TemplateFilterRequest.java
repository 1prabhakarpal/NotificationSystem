package com.notofication.api.models.request;

import com.notofication.api.models.entities.Template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TemplateFilterRequest extends BaseSearchDTO<Template> {
    private String name;

    @Override
    public Class<Template> getEntityClass() {
        return Template.class;
    }
}
