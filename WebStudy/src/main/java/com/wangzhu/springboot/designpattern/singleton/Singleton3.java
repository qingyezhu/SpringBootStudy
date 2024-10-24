package com.wangzhu.springboot.designpattern.singleton;

/**
 * 单例模式-饿汉式<br/>
 * Created by wangzhu on 2024/9/25 10:29.
 **/
public class Singleton3 {
    private static final Singleton3 INSTANCE = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return INSTANCE;
    }
}
