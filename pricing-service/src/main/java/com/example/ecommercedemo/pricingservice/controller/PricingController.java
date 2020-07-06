package com.example.ecommercedemo.pricingservice.controller;

import com.example.ecommercedemo.pricingservice.model.PricingModel;
import com.example.ecommercedemo.pricingservice.repository.PricingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
public class PricingController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PricingController.class);

    @Autowired
    private PricingRepository pricingRepository;

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public @ResponseBody Iterable<PricingModel> getAllPrices() throws Exception {
        LOGGER.debug("PricingController - get all prices");
        return pricingRepository.findAll();
    }

    @RequestMapping(value = "/prices/productIds", method = RequestMethod.GET)
    public @ResponseBody Iterable<PricingModel> getPricesByProductIds(@RequestParam(value="productIds", required=true) String productIds) throws Exception {
        LOGGER.debug("PricingController - get prices by product Ids");
        Iterable<PricingModel> prices = null;
        if (!StringUtils.isEmpty(productIds)) {
            String[] idArr = productIds.split(",");
            Set<String> idSet = new HashSet(Arrays.asList(idArr));
            prices = pricingRepository.findByProductIds(idSet);
        }
        return prices;
    }

    @RequestMapping(value = "/prices/{id}", method = RequestMethod.POST)
    public @ResponseBody PricingModel addPricingModel(@RequestBody PricingModel pricingModel) throws Exception {
        LOGGER.debug("PricingController - add pricingModel");
        return pricingRepository.save(pricingModel);
    }

    @RequestMapping(value = "/prices/{id}", method = RequestMethod.PUT)
    public @ResponseBody PricingModel updatePricingModel(@RequestBody PricingModel pricingModel) throws Exception {
        LOGGER.debug("PricingController - update pricingModel");
        return pricingRepository.save(pricingModel);
    }
}
