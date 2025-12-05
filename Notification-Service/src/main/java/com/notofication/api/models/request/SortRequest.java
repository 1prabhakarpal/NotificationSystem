package com.notofication.api.models.request;

import com.notofication.api.models.enums.SortType;

import lombok.Data;

@Data
public class SortRequest {
    private String sortKey;
    private SortType sortType;
}
