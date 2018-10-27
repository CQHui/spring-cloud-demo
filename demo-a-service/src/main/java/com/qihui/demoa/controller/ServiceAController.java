package com.qihui.demoa.controller;

import com.qihui.common.exception.BusinessException;
import com.qihui.demoa.client.ServiceBClient;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static com.qihui.common.enums.ErrorCodeEnum.GL99999999;

@RefreshScope
@RestController
public class ServiceAController {

    @Value("${name:unknown}")
    private String name;

    private final EurekaDiscoveryClient discoveryClient;
    private final ServiceBClient serviceBClient;

    @Autowired
    public ServiceAController(EurekaDiscoveryClient discoveryClient, ServiceBClient serviceBClient) {
        this.discoveryClient = discoveryClient;
        this.serviceBClient = serviceBClient;
    }

    @GetMapping(value = "/")
    @ApiOperation("测试调用serviceB")
    public String printServiceA() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")" + "===>name:" + name + "<br/>" + serviceBClient.printServiceB();
    }

    @GetMapping(path = "/current")
    @ApiOperation("当前用户")
    public Principal getCurrentAccount(Principal principal) {
        return principal;
    }

    @GetMapping(path = "/error")
    @ApiOperation("报错测试")
    public void errorTest() {
        throw new BusinessException(GL99999999);
    }

}