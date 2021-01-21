package com.example.seataorderdemo.controller;

import com.example.seataorderdemo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public void createOrder(Integer accountId, Integer productId,
                            BigDecimal payAmount, Integer buyNumber) {
        logger.info("生成订单，账户id:{},商品id:{},支付金额:{},购买数量:{}",
                accountId, productId, payAmount, buyNumber);
        orderService.createOrder(accountId, productId, payAmount, buyNumber);
    }
}
