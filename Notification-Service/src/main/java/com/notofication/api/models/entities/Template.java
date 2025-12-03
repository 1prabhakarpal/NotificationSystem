package com.notofication.api.models.entities;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "templates")
@Builder
public class Template extends AbstractEntity {
    private UUID id;
    private String name;
    private Map<String, String> templateVariables;
    private String messageTemplate;
    private UUID tenantId;
}
