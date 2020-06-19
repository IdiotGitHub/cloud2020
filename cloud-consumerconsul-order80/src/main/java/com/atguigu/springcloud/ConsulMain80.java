package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 */
@SpringBootApplication
//此注解用于向Consul或zookeeper注册服务
@EnableDiscoveryClient
public class ConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMain80.class, args);
    }
}
