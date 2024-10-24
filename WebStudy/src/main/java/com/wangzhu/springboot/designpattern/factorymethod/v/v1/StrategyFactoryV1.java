package com.wangzhu.springboot.designpattern.factorymethod.v.v1;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/**
 * Created by wangzhu on 2024/9/25 17:38.
 **/
public abstract class StrategyFactoryV1<T, S extends Strategy<T>> implements InitializingBean, ApplicationContextAware {

    private Map<T, S> strategyMap;
    private ApplicationContext applicationContext;

    public S getStrategy(T id) {
        return strategyMap.get(id);
    }

    // 方法一：子类实现
//    protected abstract Class<S> getStrategyType();

    // 方法二：通过反射获取策略的类型
    protected Class<S> getStrategyType() {
        // getClass 获取当前运行时实例的类
        // getGenericSuperclass 获取泛型父类
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) superclass;
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        // 获取索引为1的实际参数类型，即第二个实际参数类型
        Type actualTypeArgument = actualTypeArguments[1];

        @SuppressWarnings("unchecked")
        Class<S> clazz = (Class<S>) actualTypeArgument;
        return clazz;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        // 获取Spring容器中所有S类型的Bean
        Collection<S> strategies = applicationContext.getBeansOfType(getStrategyType()).values();
        strategyMap = Maps.newHashMapWithExpectedSize(strategies.size());

        // 将所有S类型的Bean放入到strategyMap中
        for (final S strategy : strategies) {
            strategyMap.put(strategy.getId(), strategy);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
