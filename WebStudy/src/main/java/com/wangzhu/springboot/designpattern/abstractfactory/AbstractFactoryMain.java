package com.wangzhu.springboot.designpattern.abstractfactory;

/**
 * Created by wangzhu on 2024/9/25 16:56.
 **/
public class AbstractFactoryMain {

    public static void main(String[] args) {
        IFactory factory = new ConCreateFactory1();
        IProductA productA = factory.createA();
        IProductB productB = factory.createB();
        System.out.println(productA);
        System.out.println(productB);
    }
}
