package com.qihui.demoaserviceapi.service.fallback;

import com.qihui.demoaserviceapi.service.ServiceAFeign;
import org.springframework.stereotype.Component;

/**
 * @author chenqihui
 * @date 2018/12/29
 */
@Component
public class ServiceAFeignHystrix implements ServiceAFeign {

    @Override
    public String getName() {
        return null;
    }
}
