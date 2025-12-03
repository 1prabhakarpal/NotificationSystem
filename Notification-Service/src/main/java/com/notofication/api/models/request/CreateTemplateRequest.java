package com.notofication.api.models.request;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTemplateRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private Map<String, String> templateVariables;

    @NotBlank(message = "Message template is required")
    private String messageTemplate;

}
