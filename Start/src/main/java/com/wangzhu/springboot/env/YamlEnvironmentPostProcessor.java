package com.wangzhu.springboot.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
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
 * Created by wangzhu on 2024/12/11 16:06.
 **/
public class YamlEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(YamlEnvironmentPostProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        Resource resource = new ClassPathResource("start-config-v2.yml");
        yamlPropertiesFactoryBean.setResources(resource);
        Properties properties = yamlPropertiesFactoryBean.getObject();
        try {
            logger.info("fileName:{}, properties:{}", resource.getFilename(), properties);
            logger.info("hahah");
            System.out.println("aaa");
            propertySources.addFirst(new PropertiesPropertySource(resource.getFilename(), properties));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getOrder() {
        return 1000;
    }
}
