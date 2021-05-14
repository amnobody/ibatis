package com.leo.ibatis.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.io.IOException;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/02/26
 * @description
 */
@ControllerAdvice
public class GlobalControllerAdviceController {

    @InitBinder
    public void dataBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder
                        .deserializerByType(String.class, new StdScalarDeserializer<String>(String.class) {
                            @Override
                            public String deserialize(JsonParser jsonParser, DeserializationContext ctx)
                                    throws IOException {
                                // 重点在这儿:如果为空白则返回null
                                String value = jsonParser.getValueAsString();
                                if (value == null || "".equals(value.trim())) {
                                    return null;
                                }
                                return value;
                            }
                        });
            }
        };
    }
}
