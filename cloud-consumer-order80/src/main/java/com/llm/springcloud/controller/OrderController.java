package com.llm.springcloud.controller;

import com.llm.springcloud.entities.PaymentEntity;
import com.llm.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description: 消费者controller层，调用者
 * @author: LiuLuMing
 * @createtime: 2020-12-11 17:29
 */
@RestController()
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @PostMapping("consumer/payment/create")
    public CommonResult<PaymentEntity> create(@RequestBody PaymentEntity paymentEntity){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",paymentEntity,CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<PaymentEntity> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
