package com.example.ecommercedemo.productcatalogservice.controller;

import com.example.ecommercedemo.productcatalogservice.model.ProductCatalogModel;
import com.example.ecommercedemo.productcatalogservice.repository.ProductCatalogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.ecommercedemo.productcatalogservice.model.Message;

@RestController
@EnableBinding(Source.class)
public class ProductCatalogController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductCatalogController.class);

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @Autowired
    private Source source;

    public enum AuditTrailEnum {
        VIEW_PRODUCT_CATALOGS,
        VIEW_PRODUCT,
        ADD_PRODUCT,
        UPDATE_PRODUCT
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductCatalogModel> getAllProducts() throws Exception {
        LOGGER.debug("ProductCatalogController - get all products");
        sendMessage(AuditTrailEnum.VIEW_PRODUCT_CATALOGS.name());
        return productCatalogRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Optional<ProductCatalogModel> getProductById(@PathVariable String id) throws Exception {
        LOGGER.debug("ProductCatalogController - find product by id {}", id);
        sendMessage(AuditTrailEnum.VIEW_PRODUCT.name());
        return productCatalogRepository.findById(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductCatalogModel addProduct(@RequestBody ProductCatalogModel product) throws Exception {
        LOGGER.debug("ProductCatalogController - add product");
        sendMessage(AuditTrailEnum.ADD_PRODUCT.name());
        return productCatalogRepository.save(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ProductCatalogModel updateProduct(@RequestBody ProductCatalogModel product) throws Exception {
        LOGGER.debug("ProductCatalogController - update product");
        sendMessage(AuditTrailEnum.UPDATE_PRODUCT.name());
        return productCatalogRepository.save(product);
    }

    protected void sendMessage(String message) {
        Message m = new Message(message);
        source.output().send(MessageBuilder.withPayload(m).build());
    }
}
