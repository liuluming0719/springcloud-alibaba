package com.llm.springcloud.service.impl;

import com.llm.springcloud.dao.PaymentDao;
import com.llm.springcloud.entities.PaymentEntity;
import com.llm.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: service层实现类
 * @author: LiuLuMing
 * @createtime: 2020-12-11 16:03
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public Long create(PaymentEntity paymentEntity) {
        paymentDao.create(paymentEntity);
        return paymentEntity.getId();
    }

    @Override
    public PaymentEntity get(Long id) {
        return paymentDao.get(id);
    }
}
