package com.example.seatastoragedemo.service;

public interface ProductService {
    /**
     * 扣减库存数量
     *
     * @param productId 商品id
     * @param number    扣减数量
     * @throws Exception
     */
    void reduceStock(Integer productId, Integer number) throws Exception;
}
