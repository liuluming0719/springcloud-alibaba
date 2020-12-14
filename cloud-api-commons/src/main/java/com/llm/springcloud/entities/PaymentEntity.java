package com.llm.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 实体类
 * @author: LiuLuMing
 * @createtime: 2020-12-11 16:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity implements Serializable {

    private Long id;
    private String serial;
}
