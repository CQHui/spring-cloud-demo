package com.qihui.demoa;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenqihui
 * @date 2018/12/26
 */
public class LimitTest {

    @Test
    public void limit() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                String result = restTemplate.getForObject("http://127.0.0.1:8080/limit/current", String.class);
                if (result != null) {
                    System.out.println("请求成功，result = " + result);
                } else {
                    System.out.println("请求失败");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

    }
}
