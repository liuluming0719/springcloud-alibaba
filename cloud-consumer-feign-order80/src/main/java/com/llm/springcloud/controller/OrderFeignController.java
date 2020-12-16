package com.llm.springcloud.controller;

import com.llm.springcloud.entities.PaymentEntity;
import com.llm.springcloud.service.PaymentFeignService;
import com.llm.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @description: feign  controller层
 * @author: LiuLuMing
 * @createtime: 2020-12-15 18:14
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    PaymentFeignService paymentFeignService;

    /**
     * 功能说明: 通过调用feign对外暴露的接口，通过id查询payment实体信息
     *
     * @param id id
     * @return 返回payment实体信息
     * @author  LiuLuMing
     * @createtime  2020/12/15 18:17
     */
    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<PaymentEntity> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
