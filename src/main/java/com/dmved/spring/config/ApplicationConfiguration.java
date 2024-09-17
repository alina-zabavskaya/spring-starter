package com.dmved.spring.config;

import com.dmved.spring.database.pool.ConnectionPool;
import com.dmved.spring.database.repository.CrudRepository;
import com.dmved.spring.database.repository.UserRepository;
import com.dmved.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
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
        @Bean
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool2(@Value("${db.username}") String username){
            return new ConnectionPool(username, 20);
        }

        @Bean
        public UserRepository userRepository(ConnectionPool pool2){
            return new UserRepository(pool2);
        }
}
