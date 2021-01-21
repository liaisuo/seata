package com.example.seataaccountdemo.service.impl;

import com.example.seataaccountdemo.dao.AccountMapper;
import com.example.seataaccountdemo.service.AccountService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reduceBalance(Integer accountId, BigDecimal amount) throws Exception {
        logger.info("全局事务XID:{}", RootContext.getXID());

        // 检查账户余额是否充足
        BigDecimal balance = accountMapper.getAccountBlance(accountId);
        if (amount.compareTo(balance) > 0) {
            logger.error("账户余额不足，扣减失败！accountId:{},amount:{}", accountId, amount);
            throw new Exception("账户余额不足！");
        }

        // 更新账户余额
        Integer result = accountMapper.updateAccountBlance(accountId, amount);
        if (result <= 0) {
            logger.error("更新账户余额失败！accountId:{},amount:{}", accountId, amount);
            throw new Exception("更新账户余额失败！");
        }

        logger.info("更新账户余额成功！accountId:{},amount:{}", accountId, amount);
    }

}
