package com.wangzhu.springboot.designpattern.factorymethod.v.v0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;

/**
 * Created by wangzhu on 2024/9/25 17:31.
 **/
@Component
public class FormItemConverterFactory {
    private static final EnumMap<FormItemTypeEnum, FormItemConverter> CONVERTER_MAP = new EnumMap<FormItemTypeEnum, FormItemConverter>(FormItemTypeEnum.class);

    public FormItemConverter getConverter(FormItemTypeEnum type) {
        return CONVERTER_MAP.get(type);
    }

    @Autowired
    public void setConverters(List<FormItemConverter> converters) {
        for (final FormItemConverter converter : converters) {
            CONVERTER_MAP.put(converter.getType(), converter);
        }
    }
}
