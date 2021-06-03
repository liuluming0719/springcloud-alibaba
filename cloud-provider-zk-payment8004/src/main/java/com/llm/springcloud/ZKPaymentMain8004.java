package com.llm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: zookeeper提供者主启动类8004
 * @author: LiuLuMing
 * @createtime: 2021-06-03 21:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZKPaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(ZKPaymentMain8004.class,args);
    }
}
