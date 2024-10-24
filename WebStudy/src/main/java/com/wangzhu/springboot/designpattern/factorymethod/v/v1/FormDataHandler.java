package com.wangzhu.springboot.designpattern.factorymethod.v.v1;

/**
 * Created by wangzhu on 2024/9/25 17:24.
 **/
public interface FormDataHandler extends Strategy<String> {

    @Override
    default String getId() {
        return getFormCode();
    }

    String getFormCode();
}
