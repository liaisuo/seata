package com.example.seatastoragedemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDao {

    /**
     * 查询商品的库存数量
     *
     * @param productId 商品id
     * @return Integer
     */
    @Select("SELECT stock FROM product where id=#{productId}")
    Integer getProductStock(@Param("productId") Integer productId);

    /**
     * 更新商品的库存数量
     *
     * @param productId 商品id
     * @param number    扣减数量
     * @return Integer
     */
    @Update("UPDATE product SET stock=stock-#{number} WHERE id=#{productId}")
    Integer updateProductStock(@Param("productId") Integer productId,
                               @Param("number") Integer number);
}
