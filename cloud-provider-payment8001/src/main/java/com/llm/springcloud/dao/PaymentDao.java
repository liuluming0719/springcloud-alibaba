package com.llm.springcloud.dao;

import com.llm.springcloud.entities.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: dao层
 * @author: LiuLuMing
 * @createtime: 2020-12-11 16:04
 */
@Mapper
public interface PaymentDao {

    /**
     * 功能说明: 新增
     *
     * @param paymentEntity 实体
     * @return 返回id
     * @author  LiuLuMing
     * @createtime  2020/12/11 16:41
     */
    int create(PaymentEntity paymentEntity);

    /**
     * 功能说明: 通过id查询
     *
     * @param id 主键id
     * @return 返回实体
     * @author  LiuLuMing
     * @createtime  2020/12/11 17:01
     */
    PaymentEntity get(Long id);
}
