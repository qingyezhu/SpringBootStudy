package com.wangzhu.springboot.designpattern.abstractfactory;

/**
 * Created by wangzhu on 2024/9/25 16:52.
 **/
public class ConCreateFactory1 implements IFactory {

    @Override
    public IProductA createA() {
        return new ConCreateProductA1();
    }

    @Override
    public IProductB createB() {
        return new ConCreateProductB1();
    }
}
