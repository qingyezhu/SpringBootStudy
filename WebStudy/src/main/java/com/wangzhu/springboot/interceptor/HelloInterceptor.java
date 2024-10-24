package com.wangzhu.springboot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by wangz on 2024/9/12 15:42.
 **/
public class HelloInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(HelloInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("interceptor_count");
        count = Objects.isNull(count) ? 1 : (count + 1);
        session.setAttribute("interceptor_count", count);
        logger.info("interceptor_count: {}", count);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
