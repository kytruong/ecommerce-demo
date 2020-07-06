package com.example.ecommercedemo.productcatalogservice.repository;

import com.example.ecommercedemo.productcatalogservice.model.ProductCatalogModel;
import org.springframework.data.mongodb.repository.MongoRepository;

// No need implementation, all CRUD operations provided out-of-the-box thanks to Spring Data
public interface ProductCatalogRepository extends MongoRepository<ProductCatalogModel, String> {
}
