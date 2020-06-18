package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Controller
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    /**
     * 如果这里是解析json封装成对象的话最好加一个@RequestBody
     *
     * @param payment 参数
     * @return 结果
     */
    @ResponseBody
    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功,调用端口为" + serverPort, result);
        } else {
            return new CommonResult<Integer>(444, "插入数据库失败,调用端口为" + serverPort, null);
        }
    }

    @ResponseBody
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果" + result);
        if (result != null) {
            return new CommonResult<Payment>(200, "查询成功,调用端口为" + serverPort, result);
        } else {
            return new CommonResult<Payment>(444, "查询失败失败，查询ID:" + id, null);
        }
    }

}
