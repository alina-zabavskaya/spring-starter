package com.dmved.spring;

import com.dmved.spring.database.pool.ConnectionPool;
import com.dmved.spring.database.repository.CompanyRepository;
import java.io.Serializable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {

        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            //clazz -> String -> Map<String,Object>
            System.out.println(context.getBean("pool1", ConnectionPool.class));

            CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRepository);
        }
    }
}