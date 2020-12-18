package com.llm.springcloud.service.impl;

import com.llm.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @description: 处理异常接口实现类
 * @author: LiuLuMing
 * @createtime: 2020-12-17 15:22
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK O(∩_∩)O哈哈~  id:"+id;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut O(∩_∩)O哈哈~ id:"+id;
    }
}
