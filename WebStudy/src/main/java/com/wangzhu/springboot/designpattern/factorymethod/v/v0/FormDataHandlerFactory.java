package com.wangzhu.springboot.designpattern.factorymethod.v.v0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhu on 2024/9/25 17:23.
 **/
@Component
public class FormDataHandlerFactory {
    private static final Map<String, FormDataHandler> FORM_DATA_HANDLER_MAP = new HashMap<>(16);

    public FormDataHandler getHandler(String formCode) {
        return FORM_DATA_HANDLER_MAP.get(formCode);
    }

    @Autowired(required = false)
    public void setFormDataHandlers(List<FormDataHandler> handlers) {
        for (final FormDataHandler handler : handlers) {
            FORM_DATA_HANDLER_MAP.put(handler.getFormCode(), handler);
        }
    }
}
