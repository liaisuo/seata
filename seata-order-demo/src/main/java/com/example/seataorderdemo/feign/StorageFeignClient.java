package com.example.seataorderdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-demo")
public interface StorageFeignClient {
    /**
     * 扣减库存
     *
     * @param productId 商品id
     * @param number    扣减数量
     */
    @PostMapping("/storage/reduceStock")
    void reduceStock(@RequestParam("productId") Integer productId,
                     @RequestParam("number") Integer number);
}
