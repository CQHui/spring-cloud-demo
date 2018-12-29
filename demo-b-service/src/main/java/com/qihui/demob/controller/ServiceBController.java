package com.qihui.demob.controller;

import com.qihui.demoaserviceapi.service.ServiceAFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RefreshScope
@RestController
public class ServiceBController {

    @Autowired
    EurekaDiscoveryClient discoveryClient;

    @Resource
    ServiceAFeign serviceAFeign;

    @Value("${msg:unknown}")
    private String msg;

    @GetMapping(value = "/")
    @ApiOperation("printServiceB")
    public String printServiceB() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")" + "===>Say " + msg;
    }

    @GetMapping(value = "/servicea")
    @ApiOperation("测试调用a")
    public String printServiceA() {
        return serviceAFeign.getName();
    }
}