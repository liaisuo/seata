package com.example.seataorderdemo.service.impl;

import com.example.seataorderdemo.dao.OrderMapper;
import com.example.seataorderdemo.feign.AccountFeignClient;
import com.example.seataorderdemo.feign.StorageFeignClient;
import com.example.seataorderdemo.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageFeignClient storageFeignClient;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void createOrder(Integer accountId, Integer productId,
                            BigDecimal payAmount, Integer buyNumber) {
        logger.info("全局事务XID:{}", RootContext.getXID());

        // 扣减库存
        storageFeignClient.reduceStock(productId, buyNumber);

        // 扣减账户余额
        accountFeignClient.reduceBalance(accountId, payAmount);

        // 生成订单
        orderMapper.saveOrder(productId, payAmount);

        logger.info("订单生成成功！");
    }
}
