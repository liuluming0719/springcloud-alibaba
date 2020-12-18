package com.llm.springcloud.controller;

import com.llm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: controller层
 * @author: LiuLuMing
 * @createtime: 2020-12-17 09:57
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        String result = paymentService.payment_OK(id);
        log.info("***result:"+result);
        return result;
    }

    @GetMapping("hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable Integer id){
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("***result:"+result);
        return result;
    }

    @GetMapping("hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }

}
