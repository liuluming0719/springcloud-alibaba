package com.llm.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 配置类
 * @author: LiuLuMing
 * @createtime: 2020-12-11 17:27
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced  //采用轮询的方式调用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}