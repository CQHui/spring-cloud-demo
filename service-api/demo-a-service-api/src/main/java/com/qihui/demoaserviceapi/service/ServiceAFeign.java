package com.qihui.demoaserviceapi.service;

import com.qihui.demoaserviceapi.service.fallback.ServiceAFeignHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chenqihui
 * @date 2018/12/29
 */
@FeignClient(value = "demo-a-service", fallback = ServiceAFeignHystrix.class)
public interface ServiceAFeign {

    @GetMapping("feigin/getName")
    String getName();
}
