package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface PaymentDao {
    /**
     * @param payment 支付实体类
     * @return 创建成功数量
     */
    public int create(Payment payment);

    /**
     * @param id 实体id
     * @return 查询到的实体类
     */
    public Payment getPaymentById(@Param("id") Long id);
}
