package com.wangzhu.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by wangz on 2024/9/9 16:34.
 **/
@RestController
public class HelloController implements BeanNameAware {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        logger.info("setBeanName beanName:{}", beanName);
        this.beanName = beanName;
    }

    @PostConstruct
    public void init(){
        logger.info("init");
    }

    @GetMapping("/")
    public String index() {
        return "spring boot web hello";
    }
}
