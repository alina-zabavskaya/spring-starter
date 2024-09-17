package com.dmved.spring.config;

import com.dmved.spring.config.condition.JpaCondition;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init(){
        System.out.println("Jpa configuration is enabled");
    }
}