package com.example.ecommercedemo.pricingservice.model;

import javax.persistence.*;

@Entity
@Table(name = "Prices")
public class PricingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "price")
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // The no-argument constructor is a requirement
    // (tools like Hibernate use reflection on this constructor to instantiate objects)
    protected PricingModel() {
    }

    public PricingModel(String productId, Double price) {
        this.productId = productId;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("PricingModel[id=%d, productId='%s', price='%d']", id, productId, price);
    }
}
