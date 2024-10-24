package com.wangzhu.springboot.designpattern.factorymethod;

/**
 * Created by wangzhu on 2024/9/25 16:47.
 **/
public class ConCreateFactoryB implements IFactory {
    @Override
    public IProduct create() {
        return new ConCreateProductB();
    }
}
