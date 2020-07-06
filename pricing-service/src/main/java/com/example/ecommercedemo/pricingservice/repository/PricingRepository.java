package com.example.ecommercedemo.pricingservice.repository;

import com.example.ecommercedemo.pricingservice.model.PricingModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface PricingRepository extends CrudRepository<PricingModel, Long> {
    @Query("FROM PricingModel p WHERE p.productId IN ?1")
    Iterable<PricingModel> findByProductIds(Set<String> productIds);
}
