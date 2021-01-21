package com.example.seataorderdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("seata-account-demo")
public interface AccountFeignClient {
    /**
     * 扣减余额
     *
     * @param accountId 账户id
     * @param amount    扣减金额
     */
    @PostMapping("/account/reduceBalance")
    void reduceBalance(@RequestParam("accountId") Integer accountId,
                       @RequestParam("amount") BigDecimal amount);
}
