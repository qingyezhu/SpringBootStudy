package com.wangzhu.springboot.designpattern.factorymethod.v.v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangzhu on 2024/9/25 17:58.
 **/
@Configuration
public class FactoryConfig {

    @Bean
    public StrategyFactoryV2<String, FormDataHandler> formDataHandlerFactory() {
        return new StrategyFactoryV2<>(FormDataHandler.class);
    }

    @Bean
    public StrategyFactoryV2<FormItemTypeEnum, FormItemConverter> formItemConverterFactory() {
        return new StrategyFactoryV2<>(FormItemConverter.class);
    }

    @Bean
    public StrategyFactoryV2<String, ListDataFetcher> listDataFetcherFactory() {
        return new StrategyFactoryV2<>(ListDataFetcher.class);
    }
}
