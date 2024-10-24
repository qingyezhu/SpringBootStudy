package com.wangzhu.springboot.designpattern.simplefactory;

/**
 * Created by wangzhu on 2024/9/25 16:43.
 **/
public class Factory {
    public static IProduct create(int type) {
        switch (type) {
            case 1:
                return new ConCreateProductA();
            case 2:
                return new ConCreateProductB();
        }
        return null;
    }
}
