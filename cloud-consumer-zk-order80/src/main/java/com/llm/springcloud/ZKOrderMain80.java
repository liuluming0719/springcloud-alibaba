package com.llm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: zookeeper消费者主启动类80
 * @author: LiuLuMing
 * @createtime: 2021-06-03 21:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZKOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZKOrderMain80.class,args);
    }
}
