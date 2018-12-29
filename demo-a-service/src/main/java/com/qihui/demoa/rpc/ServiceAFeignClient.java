package com.qihui.demoa.rpc;

import com.qihui.demoaserviceapi.service.ServiceAFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenqihui
 * @date 2018/12/29
 */
@RestController
public class ServiceAFeignClient implements ServiceAFeign {
    @Override
    public String getName() {
        return "qihui";
    }
}
