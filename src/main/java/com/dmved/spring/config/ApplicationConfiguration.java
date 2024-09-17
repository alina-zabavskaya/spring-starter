package com.dmved.spring.config;

import com.dmved.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.dmved.spring",
               useDefaultFilters = false,
               includeFilters = {
                    @Filter(type = FilterType.ANNOTATION, value = Component.class),
                    @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                    @Filter(type = FilterType.REGEX, pattern = "com\\..+Repitory")

               })
public class ApplicationConfiguration {

}
