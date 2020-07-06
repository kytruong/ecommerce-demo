package com.example.ecommercedemo.audittrailservice.repository;

import com.example.ecommercedemo.audittrailservice.model.AuditTrailModel;
import org.springframework.data.mongodb.repository.MongoRepository;

// No need implementation, all CRUD operations provided out-of-the-box thanks to Spring Data
public interface AuditTrailRepository extends MongoRepository<AuditTrailModel, String> {
}
