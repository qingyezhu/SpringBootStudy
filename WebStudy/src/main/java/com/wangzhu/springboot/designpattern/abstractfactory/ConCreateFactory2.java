package com.wangzhu.springboot.designpattern.abstractfactory;

/**
 * Created by wangzhu on 2024/9/25 16:54.
 **/
public class ConCreateFactory2 implements IFactory{

    @Override
    public IProductA createA() {
        return new ConCreateProductA2();
    }

    @Override
    public IProductB createB() {
        return new ConCreateProductB2();
    }
}
