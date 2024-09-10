package com.wangzhu.springboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

/**
 * Created by wangz on 2024/9/9 16:39.
 **/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testHello() {
        ResponseEntity<String> responseEntity = template.getForEntity("/", String.class);
        System.out.println(responseEntity.getBody());
    }
}
