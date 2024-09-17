package com.dmved.spring;

import com.dmved.spring.config.ApplicationConfiguration;
import com.dmved.spring.database.pool.ConnectionPool;
import com.dmved.spring.service.CompanyService;
import java.io.Serializable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {

        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            //clazz -> String -> Map<String,Object>
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            System.out.println(context.getBean("pool1", ConnectionPool.class));

            var companyService = context.getBean(CompanyService.class);
            System.out.println(companyService.findById(1));
        }
    }
}