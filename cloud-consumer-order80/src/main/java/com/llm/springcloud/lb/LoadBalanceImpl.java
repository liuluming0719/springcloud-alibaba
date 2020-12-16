package com.llm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 接口实现类
 * @author: LiuLuMing
 * @createtime: 2020-12-15 16:28
 */
@Component
public class LoadBalanceImpl implements LoadBalance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第"+next+"次访问，次数："+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int i = getAndIncrement() % instances.size();//获取每个服务的位置下标
        return instances.get(i);
    }
}
