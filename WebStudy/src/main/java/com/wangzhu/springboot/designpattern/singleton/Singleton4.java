package com.wangzhu.springboot.designpattern.singleton;

/**
 * 单例模式-静态内部类模式<br/>
 * Created by wangzhu on 2024/9/25 10:32.
 **/
public class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
