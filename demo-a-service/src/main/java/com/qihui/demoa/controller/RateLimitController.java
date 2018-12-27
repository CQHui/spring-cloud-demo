package com.qihui.demoa.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.qihui.common.exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.util.concurrent.RateLimiter.*;

/**
 * @author chenqihui
 * @date 2018/12/26
 */
@RestController
@RequestMapping("/limit")
@Slf4j
public class RateLimitController {
    @Value("${name:unknown}")
    private String name;

    @Autowired
    private RateLimiter limiter;

    @GetMapping(path = "/current")
    @ApiOperation("当前用户")
    public String getCurrentAccount() throws InterruptedException {

        if (limiter.tryAcquire()) {
            log.debug("获取令牌成功!,消耗=" + limiter.acquire());
            Thread.sleep(1100);
        } else {
            log.debug("获取令牌失败!");
            throw new BusinessException("获取令牌失败");
        }
        return name;
    }

    @Bean
    public RateLimiter getRateLimitInstance() {
        return RateLimiter.create(2);
    }
}
