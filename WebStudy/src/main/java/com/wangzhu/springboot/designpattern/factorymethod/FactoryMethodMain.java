package com.wangzhu.springboot.designpattern.factorymethod;

/**
 * Created by wangzhu on 2024/9/25 16:48.
 **/
public class FactoryMethodMain {

    public static void main(String[] args) {
        IProduct productA = new ConCreateFactoryA().create();
        System.out.println(productA);

        IProduct productB = new ConCreateFactoryB().create();
        System.out.println(productB);
    }
}
