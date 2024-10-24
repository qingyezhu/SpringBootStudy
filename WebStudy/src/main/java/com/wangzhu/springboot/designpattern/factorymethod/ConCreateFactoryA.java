package com.wangzhu.springboot.designpattern.factorymethod;


/**
 * Created by wangzhu on 2024/9/25 16:45.
 **/
public class ConCreateFactoryA implements IFactory {

    @Override
    public IProduct create() {
        return new ConCreateProductA();
    }
}
