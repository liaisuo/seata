package com.example.seataaccountdemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface AccountMapper {

    /**
     * 查询账户余额
     *
     * @param accountId 账户id
     * @return BigDecimal
     */
    @Select("SELECT t.balance FROM account t WHERE t.id=#{accountId}")
    BigDecimal getAccountBlance(@Param("accountId") Integer accountId);

    /**
     * 更新账户余额
     *
     * @param accountId 账户id
     * @param amount    金额
     * @return Integer
     */
    @Update("UPDATE account SET balance=balance-#{amount} WHERE id=#{accountId}")
    Integer updateAccountBlance(@Param("accountId") Integer accountId,
                                @Param("amount") BigDecimal amount);
}
