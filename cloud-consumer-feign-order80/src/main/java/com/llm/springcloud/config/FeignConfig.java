package com.llm.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置打印日志信息
 * @author: LiuLuMing
 * @createtime: 2020-12-16 10:49
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
//        return Logger.Level.HEADERS;除了basic中定义的信息之外，还有请求和响应的头信息
//        return Logger.Level.FULL;除了headers中定义的信息之外，还有请求和响应的正文及元数据
//        return Logger.Level.NONE;默认的 不显示任何日志
        return Logger.Level.BASIC;//仅记录请求方法、URL、响应状态码及执行时间
    }

}
