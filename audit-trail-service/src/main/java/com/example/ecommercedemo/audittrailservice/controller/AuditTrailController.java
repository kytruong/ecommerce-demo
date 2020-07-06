package com.example.ecommercedemo.audittrailservice.controller;

import com.example.ecommercedemo.audittrailservice.model.AuditTrailModel;
import com.example.ecommercedemo.audittrailservice.repository.AuditTrailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditTrailController {
    private final static Logger LOGGER = LoggerFactory.getLogger(AuditTrailController.class);

    @Autowired
    private AuditTrailRepository auditTrailRepository;

    @RequestMapping(value = "/audittrails", method = RequestMethod.GET)
    public List<AuditTrailModel> getAllAuditTrails() throws Exception {
        LOGGER.debug("AuditTrailController - get all audit trails");
        return auditTrailRepository.findAll();
    }
}
