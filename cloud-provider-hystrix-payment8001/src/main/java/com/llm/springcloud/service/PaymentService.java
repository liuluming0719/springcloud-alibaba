package com.llm.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description: service层
 * 降低配置！@HystrixCommand 先从自身找问题
 *          设置自身调用的超时时间峰值，超过了需要做服务降级处理
 * @author: LiuLuMing
 * @createtime: 2020-12-17 09:52
 */
@Service
public class PaymentService {

    //成功
    public String payment_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"O(∩_∩)O哈哈~"  ;
    }

    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"o(╥﹏╥)o"+" 耗时(秒)";

    }
    //服务降级处理方法
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"系统繁忙，请稍后再试，id："+id+"\t"+"o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
//            return "id不能为负数";
            throw new RuntimeException("id不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+simpleUUID;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后再试 o(╥﹏╥)o~~~   id："+id;
    }

    public static void main(String[] args) {
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.randomUUID());
        System.out.println(IdUtil.randomUUID());
        System.out.println(IdUtil.fastSimpleUUID());
        System.out.println(IdUtil.fastSimpleUUID());
        System.out.println(IdUtil.fastUUID());
        System.out.println(IdUtil.fastUUID());
        System.out.println(IdUtil.objectId());
        System.out.println(IdUtil.objectId());
    }
}
