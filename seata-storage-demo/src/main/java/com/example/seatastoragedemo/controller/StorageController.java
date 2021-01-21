package com.example.seatastoragedemo.controller;

import com.example.seatastoragedemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private Logger logger = LoggerFactory.getLogger(StorageController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/reduceStock")
    public void reduceStock(Integer productId, Integer number) throws Exception {
        logger.info("扣减库存，商品id:{},数量:{}", productId, number);
        productService.reduceStock(productId, number);
    }
}
