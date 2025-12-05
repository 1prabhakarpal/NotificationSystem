package com.notofication.api.services.interfaces;

import com.notofication.api.models.request.CreateTemplateRequest;
import com.notofication.api.models.request.TemplateFilterRequest;
import com.notofication.api.models.response.FilterTemplateRespose;
import com.notofication.api.models.response.TemplateResponse;

public interface TemplateService {

    TemplateResponse createTemplate(CreateTemplateRequest templateRequest);

    FilterTemplateRespose filterTemplate(TemplateFilterRequest request);

}
