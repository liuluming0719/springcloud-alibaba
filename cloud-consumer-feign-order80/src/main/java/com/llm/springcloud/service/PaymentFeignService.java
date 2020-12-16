package com.llm.springcloud.service;

import com.llm.springcloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: feign  service接口
 * @author: LiuLuMing
 * @createtime: 2020-12-15 18:06
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * 功能说明: 模拟超时情况，openfeign默认是等待一秒，超过后就报错
     *
     * @param
     * @return 端口号
     * @author  LiuLuMing
     * @createtime  2020/12/16 10:28
     */
    @GetMapping("payment/feign/timeout")
    String paymentFeignTimeout();
}
