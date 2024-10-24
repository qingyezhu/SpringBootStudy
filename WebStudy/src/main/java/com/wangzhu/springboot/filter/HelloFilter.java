package com.wangzhu.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by wangz on 2024/9/12 15:29.
 **/
@WebFilter
public class HelloFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(HelloFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession();
        Integer count = (Integer) session.getAttribute("filter_count");
        count = Objects.isNull(count) ? 1 : (count + 1);
        session.setAttribute("filter_count", count);
        logger.info("filter_count: {}", count);

        chain.doFilter(request, response);
    }
}
