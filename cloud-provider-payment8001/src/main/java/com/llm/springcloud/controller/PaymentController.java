package com.llm.springcloud.controller;

import com.llm.springcloud.entities.PaymentEntity;
import com.llm.springcloud.service.PaymentService;
import com.llm.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description: 生产者支付controller层
 * @author: LiuLuMing
 * @createtime: 2020-12-11 16:00
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping("create")
    public CommonResult create(@RequestBody PaymentEntity paymentEntity){
        Long id = paymentService.create(paymentEntity);
        log.info("*****插入结果："+id);
        if (id != null){  //成功
            return new CommonResult(200,"插入数据库成功,serverPort"+serverPort,id);
        }else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        PaymentEntity paymentEntity = paymentService.get(id);
        log.info("*****查询结果："+paymentEntity);
        if (paymentEntity != null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功,serverPort"+serverPort,paymentEntity);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }

    }

    @GetMapping("payment/discovery")
    public DiscoveryClient discoveryClient(){
        //得到所有服务名
        List<String> services = discoveryClient.getServices();
        services.forEach(element->
            log.info("***service***"+element)
        );
        //得到服务名对应的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(element->
                log.info(element.getServiceId()+"\t"+element.getHost()+"\t"
                +element.getPort()+"\t"+element.getUri())
                );
        return discoveryClient;
    }

    @GetMapping("lb")
    public String getServerPort(){
        return serverPort;
    }

    @GetMapping("feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
