package com.example.seataorderdemo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface OrderMapper {

    /**
     * 保存订单
     *
     * @param productId 商品id
     * @param payAmount 支付金额
     * @return Integer
     */
    @Insert("INSERT INTO orders(product_id,pay_amount,create_time) " +
            "VALUES(#{productId},#{payAmount},NOW())")
    Integer saveOrder(@Param("productId") Integer productId,
                      @Param("payAmount") BigDecimal payAmount);
}
