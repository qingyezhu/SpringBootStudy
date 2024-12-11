package com.wangzhu.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Arrays;

/**
 * 配置文件加载顺序<br/>
 * 1）先加载config/*.properties,config/*.yml，再加载*.properties,*.yml<br/>
 * 2) 先加载application.properties，再加载application.yml<br/>
 * 3) 以上同名的不会被覆盖<br/>
 * 4）若存在profile的配置文件，则会先加载profile的配置文件，并会覆盖同名的<br/>
 * Created by wangz on 2024/9/9 16:36.
 **/
@ServletComponentScan(basePackages = "com.wangzhu.springboot.filter")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            System.out.println("spring boot start");
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                //System.out.println(beanName);
            }
            //System.out.println(context.getEnvironment());

            ProtectionDomain protectionDomain = ApplicationContext.class.getProtectionDomain();
            CodeSource codeSource = protectionDomain.getCodeSource();
            System.out.println(codeSource.getLocation());
        };
    }
}
