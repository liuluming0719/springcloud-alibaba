package com.llm.myRule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 自定义负载均衡算法
 * @author: LiuLuMing
 * @createtime: 2020-12-15 11:37
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //return new RandomRule();//定义为随机
//        return new RoundRobinRule();//定义为轮询
//        return new WeightedResponseTimeRule();//响应速度越快的实例选择权重越大，越容易被选择
        return new BestAvailableRule();//会先过滤掉多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发最小的服务
    }


}
