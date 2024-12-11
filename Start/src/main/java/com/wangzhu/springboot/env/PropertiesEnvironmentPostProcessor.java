package com.wangzhu.springboot.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * Created by wangzhu on 2024/12/11 15:28.
 **/
public class PropertiesEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesEnvironmentPostProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        Resource resource = new ClassPathResource("start-config-v2.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource.getInputStream());
            logger.info("fileName:{}, properties:{}", resource.getFilename(), properties);
            propertySources.addFirst(new PropertiesPropertySource(resource.getFilename(), properties));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getOrder() {
        // 按order升序调用，越大越后调用
        return 2000;
    }
}
