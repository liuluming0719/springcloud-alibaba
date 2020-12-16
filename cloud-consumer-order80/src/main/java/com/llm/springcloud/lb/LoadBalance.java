package com.llm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @description: 手写负载均衡接口
 * @author: LiuLuMing
 * @createtime: 2020-12-15 16:26
 */
public interface LoadBalance {

    ServiceInstance instance(List<ServiceInstance> instances);
}
