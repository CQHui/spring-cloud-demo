package com.qihui.gateway.controller;

import com.qihui.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.qihui.common.enums.ErrorCodeEnum.GL99999999;

/**
 * @author chenqihui
 * @date 2018/10/28
 */
@RestController
@Slf4j
public class ErrorController extends BasicErrorController {

    public ErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }


    @Override
    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
        String message = (String) body.get("message");
        int code = GL99999999.getCode();
        log.error("业务异常={}", message);


        Throwable exception = (Throwable) new ServletRequestAttributes(request)
                .getAttribute("javax.servlet.error.exception", RequestAttributes.SCOPE_REQUEST);
        Throwable cause = exception.getCause();

        if (cause instanceof BusinessException) {
            BusinessException businessException = (BusinessException) cause;
            code = businessException.getCode();
            message = businessException.getMessage();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        return new ResponseEntity<>(map, status);
    }


}
