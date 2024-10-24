package com.wangzhu.springboot.designpattern.factorymethod.v.v1;


/**
 * Created by wangzhu on 2024/9/25 17:25.
 **/
public interface FormItemConverter extends Strategy<FormItemTypeEnum> {

    @Override
    default FormItemTypeEnum getId() {
        return getType();
    }

    FormItemTypeEnum getType();
}
