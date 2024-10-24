package com.wangzhu.springboot.designpattern.factorymethod.v.v1;

/**
 * Created by wangzhu on 2024/9/25 17:37.
 **/
public interface Strategy<T> {

    /**
     * 获取策略的表示id
     *
     * @return
     */
    T getId();
}
