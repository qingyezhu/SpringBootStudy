package com.wangzhu.springboot.teacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * springboot2.7之后，需要写一个org.springframework.boot.autoconfigure.AutoConfiguration.imports文件，放到resources/META-INF/spring目录下<br/>
 * Created by wangz on 2024/9/10 0:04.
 **/
@EnableConfigurationProperties(TeacherProperty.class)
public class TeacherAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(TeacherAutoConfiguration.class);

    @Bean
    public Teacher createTeacher(TeacherProperty teacherProperty) {
        logger.info("teacherProperty:{}", teacherProperty);
        return new Teacher();
    }
}
