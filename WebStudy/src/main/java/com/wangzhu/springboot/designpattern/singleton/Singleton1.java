package com.wangzhu.springboot.designpattern.singleton;

/**
 * 单例模式-懒汉模式（线程安全）<br/>
 * Created by wangz on 2024/9/25 10:14.
 **/
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
