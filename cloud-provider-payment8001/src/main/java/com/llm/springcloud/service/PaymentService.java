package com.llm.springcloud.service;

import com.llm.springcloud.entities.PaymentEntity;

/**
 * @description: service层
 * @author: LiuLuMing
 * @createtime: 2020-12-11 16:03
 */
public interface PaymentService {
    /**
     * 功能说明: 新增
     *
     * @param paymentEntity 实体
     * @return 返回id
     * @author  LiuLuMing
     * @createtime  2020/12/11 16:39
     */
    Long create(PaymentEntity paymentEntity);

    /**
     * 功能说明: 通过id查询
     *
     * @param id 主键id
     * @return 返回实体
     * @author  LiuLuMing
     * @createtime  2020/12/11 16:59
     */
    PaymentEntity get(Long id);
}
