package com.notofication.api.models.response;

import java.util.List;

import lombok.Data;

@Data
public class BaseTemplateRespose<I, R extends Number> {
    private List<I> data;
    private R totalCount;
    private boolean hasMoreElement;

}
