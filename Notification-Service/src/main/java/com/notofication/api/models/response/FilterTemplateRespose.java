package com.notofication.api.models.response;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FilterTemplateRespose extends BaseTemplateRespose<TemplateResponseDTO, Long> {
    public FilterTemplateRespose(List<TemplateResponseDTO> data, Long totalCount, boolean hasMoreElement) {
        setData(data);
        setTotalCount(totalCount);
        setHasMoreElement(hasMoreElement);
    }
}
