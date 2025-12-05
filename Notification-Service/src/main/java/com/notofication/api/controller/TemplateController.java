package com.notofication.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notofication.api.models.request.CreateTemplateRequest;
import com.notofication.api.models.response.TemplateResponse;
import com.notofication.api.services.interfaces.TemplateService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/template")
@RequiredArgsConstructor
public class TemplateController {
    private final TemplateService templateService;

    @PostMapping("/create")
    public ResponseEntity<TemplateResponse> createTemplate(@Valid @RequestBody CreateTemplateRequest request) {
        TemplateResponse template = templateService.createTemplate(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(template);
    }

    // @GetMapping("/all")
    // public ResponseEntity<FilterTemplateResponse>
    // getAllTemplates(TemplateFilterRequest request) {
    // return ResponseEntity.ok().body(templateService.getAllTemplates(request));
    // }

}
