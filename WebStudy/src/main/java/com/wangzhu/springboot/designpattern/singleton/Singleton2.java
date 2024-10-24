package com.wangzhu.springboot.designpattern.singleton;

/**
 * 单例模式-懒汉模式（线程安全-双重检测锁模式）<br/>
 * Created by wangz on 2024/9/25 10:17.
 **/
public class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
