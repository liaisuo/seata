package com.example.seatastoragedemo.service.impl;

import com.example.seatastoragedemo.dao.ProductDao;
import com.example.seatastoragedemo.service.ProductService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reduceStock(Integer productId, Integer number) throws Exception {
        logger.info("全局事务XID:{}", RootContext.getXID());

        // 检查库存是否充足
        Integer stock = productDao.getProductStock(productId);
        if (number.compareTo(stock) > 0) {
            logger.error("库存不足，商品id:{},扣减数量:{}", productId, number);
            throw new Exception("库存不足");
        }

        // 更新库存数量
        Integer result = productDao.updateProductStock(productId, number);
        if (result <= 0) {
            logger.error("更新商品库存失败，商品id:{},扣减数量:{}", productId, number);
            throw new Exception("更新商品库存失败");
        }

        logger.info("更新商品库存成功，商品id:{},扣减数量:{}", productId, number);
    }
}
