package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class OrderController {
    private final static String PAYMENT_URL = "http://localhost:8001";
    /**
     * 通过RestTemplate调用其他的微服务
     */
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        //使用RestTemplate调用8001服务
        //postForObject 参数一：所调用的微服务地址，参数二：微服务所需参数；参数三：存储微服务返回结果的实体类
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        //使用RestTemplate调用8001服务
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
