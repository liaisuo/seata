package com.example.seataaccountdemo.service;

import java.math.BigDecimal;

public interface AccountService {
    /**
     * 扣减账户余额
     *
     * @param accountId 账户id
     * @param amount    金额
     * @return Boolean
     */
    void reduceBalance(Integer accountId, BigDecimal amount) throws Exception;
}
