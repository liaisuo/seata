package com.example.seataorderdemo.service;

import java.math.BigDecimal;

public interface OrderService {

    /**
     * 生成订单
     *
     * @param accountId 账户id
     * @param productId 商品id
     * @param payAmount 支付金额
     * @param buyNumber 购买数量
     */
    void createOrder(Integer accountId, Integer productId,
                     BigDecimal payAmount, Integer buyNumber);
}
