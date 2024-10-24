package com.wangzhu.springboot.designpattern.simplefactory;


/**
 * Created by wangzhu on 2024/9/25 16:50.
 **/
public class SimpleFactoryMain {

    public static void main(String[] args) {
        IProduct productA = Factory.create(1);
        System.out.println(productA);
        IProduct productB = Factory.create(2);
        System.out.println(productB);
    }
}
