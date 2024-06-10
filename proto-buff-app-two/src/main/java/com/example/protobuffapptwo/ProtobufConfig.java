package com.example.protobuffapptwo;

import com.google.protobuf.util.JsonFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProtobufConfig {

    @Bean
    public JsonFormat.Printer jsonPrinter() {
        return JsonFormat.printer().includingDefaultValueFields();
    }

    @Bean
    public JsonFormat.Parser jsonParser() {
        return JsonFormat.parser();
    }
}