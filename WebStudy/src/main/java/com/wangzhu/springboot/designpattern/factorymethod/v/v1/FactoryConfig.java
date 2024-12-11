package com.wangzhu.springboot.designpattern.factorymethod.v.v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangzhu on 2024/9/25 17:58.
 **/
@Configuration
public class FactoryConfig {

    @Bean
    public StrategyFactoryV2<String, FormDataHandler> formDataHandlerFactoryV2() {
        return new StrategyFactoryV2<>(FormDataHandler.class);
    }

    @Bean
    public StrategyFactoryV2<FormItemTypeEnum, FormItemConverter> formItemConverterFactoryV2() {
        return new StrategyFactoryV2<>(FormItemConverter.class);
    }

    @Bean
    public StrategyFactoryV2<String, ListDataFetcher> listDataFetcherFactoryV2() {
        return new StrategyFactoryV2<>(ListDataFetcher.class);
    }
}
