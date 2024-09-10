package com.wangzhu.springboot.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot2.7之前需要写一个spring.factories，放到resources/META-INF目录下<br/>
 * springboot3不在支持这种方式<br/>
 * Created by wangz on 2024/9/9 16:44.
 **/
@Configuration
@EnableConfigurationProperties(StudentProperty.class)
public class StudentAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(StudentAutoConfiguration.class);

    @Bean
    public Student createStudent(StudentProperty studentProperty) {
        logger.info("userProperty:{}", studentProperty);
        return new Student();
    }
}
