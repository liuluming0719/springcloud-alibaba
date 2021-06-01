package com.llm.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 9001提供者controller层
 * @author: LiuLuMing
 * @createtime: 2021-06-01 14:53
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry,serverPort:"+serverPort+"\t id"+id;
    }
}

