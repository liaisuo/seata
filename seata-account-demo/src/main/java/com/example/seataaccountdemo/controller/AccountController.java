package com.example.seataaccountdemo.controller;

import com.example.seataaccountdemo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/reduceBalance")
    public void reduceBalance(Integer accountId, BigDecimal amount) throws Exception {
        logger.info("扣减账户余额，账户Id:{},扣减金额：{}", accountId, amount);
        accountService.reduceBalance(accountId, amount);
    }
}
