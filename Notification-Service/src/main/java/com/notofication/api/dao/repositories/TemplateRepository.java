package com.notofication.api.dao.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.notofication.api.models.entities.Template;

@Repository
public interface TemplateRepository extends MongoRepository<Template, UUID> {
    Optional<Template> findByNameIgnoreCaseAndTenantId(final String name, final UUID tenantId);
}
