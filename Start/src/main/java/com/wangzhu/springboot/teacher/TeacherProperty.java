package com.wangzhu.springboot.teacher;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangz on 2024/9/10 0:04.
 **/
@ConfigurationProperties(prefix = "teacher")
public class TeacherProperty {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TeacherProperty{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
