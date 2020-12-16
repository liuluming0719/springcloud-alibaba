package com.llm.springcloud.controller;

import com.llm.springcloud.entities.PaymentEntity;
import com.llm.springcloud.lb.LoadBalance;
import com.llm.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @description: 消费者controller层，调用者
 * @author: LiuLuMing
 * @createtime: 2020-12-11 17:29
 */
@RestController
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @Resource
    LoadBalance loadBalance;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("consumer/payment/create")
    public CommonResult<PaymentEntity> create(@RequestBody PaymentEntity paymentEntity){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",paymentEntity,CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<PaymentEntity> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommonResult<PaymentEntity> getPayment2(@PathVariable("id") Long id){
        //返回 对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头，响应状态码，响应体
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(404,"操作失败");
        }
    }

    //post方法也是同理
    //TODO

    @GetMapping("consumer/payment/lb")
    public String getServerPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalance.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
