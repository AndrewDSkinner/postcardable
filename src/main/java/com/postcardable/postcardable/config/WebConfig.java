package com.postcardable.postcardable.config;

import com.postcardable.postcardable.web.dto.request.HalfsheetRequestDto;
import com.postcardable.postcardable.web.dto.request.PostcardRequestDto;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder
                .mixIn(PostcardRequestDto.class, PostcardMixin.class)
                    .mixIn(HalfsheetRequestDto.class, PostcardMixin.HalfsheetRequestDtoMixin.class);
    }
}
