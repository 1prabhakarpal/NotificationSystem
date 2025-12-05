package com.notofication.api.models.context;

public record NotificationContext(String tenantId, boolean ignoreTenantIdInjection) {
    public NotificationContext(String tenantId) {
        this(tenantId, false);
    }
}
