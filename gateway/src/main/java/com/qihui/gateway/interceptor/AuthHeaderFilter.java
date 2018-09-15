package com.qihui.gateway.interceptor;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * The class Auth header filter.
 *
 * @author paascloud.net @gmail.com
 */

@Component
public class AuthHeaderFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(AuthHeaderFilter.class);

    private static final String BEARER_TOKEN_TYPE = "bearer ";
    private static final String OPTIONS = "OPTIONS";
    private static final String AUTH_PATH = "/auth";
    private static final String LOGOUT_URI = "/oauth/token";
    private static final String ALIPAY_CALL_URI = "/pay/alipayCallback";
    private static final String SWAGGER_DOC = "/v2/api-docs";


    /**
     * Filter type string.
     *
     * @return the string
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * Filter order int.
     *
     * @return the int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * Should filter boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Run object.
     *
     * @return the object
     */
    @Override
    public Object run() {
        log.info("AuthHeaderFilter - 开始鉴权...");
        RequestContext requestContext = RequestContext.getCurrentContext();
        try {
            doSomething(requestContext);
        } catch (Exception e) {
            log.error("AuthHeaderFilter - [FAIL] EXCEPTION={}", e.getMessage(), e);
            throw new RuntimeException("鉴权失败");
        }
        return null;
    }

    private void doSomething(RequestContext requestContext) throws ZuulException {
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();

        if (OPTIONS.equalsIgnoreCase(request.getMethod())
                || requestURI.contains(AUTH_PATH)
                || requestURI.contains(LOGOUT_URI)
                || requestURI.contains(ALIPAY_CALL_URI)
                || requestURI.endsWith(SWAGGER_DOC)) {
            return;
        }
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (null == authHeader) {
            throw new ZuulException("刷新页面重试", 403, "check token fail");
        }

        if (authHeader.startsWith(BEARER_TOKEN_TYPE)) {
            requestContext.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);

            log.info("authHeader={} ", authHeader);
            // 传递给后续微服务
            requestContext.addZuulRequestHeader("x-label", authHeader);
        }
    }

}
