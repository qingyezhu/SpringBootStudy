package com.wangzhu.springboot.designpattern.factorymethod.v.v1;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.Map;

/**
 * Created by wangzhu on 2024/9/25 17:55.
 **/
public class StrategyFactoryV2<T, S extends Strategy<T>> implements InitializingBean, ApplicationContextAware {

    private Map<T, S> strategyMap;
    private ApplicationContext applicationContext;

    public S getStrategy(T id) {
        return strategyMap.get(id);
    }

    private Class<S> strategyType;

    public StrategyFactoryV2(Class<S> strategyType) {
        this.strategyType = strategyType;
    }

    Class<S> getStrategyType() {
        return this.strategyType;
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