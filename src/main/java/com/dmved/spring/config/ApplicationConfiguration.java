package com.dmved.spring.config;

import com.dmved.spring.database.pool.ConnectionPool;
import com.dmved.spring.database.repository.UserRepository;
import com.dmved.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {
        @Bean
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool2(@Value("${db.username}") String username){
            return new ConnectionPool(username, 20);
        }

        @Bean
        public ConnectionPool pool3(){
            return new ConnectionPool("test-name", 25);
        }


        @Bean
//        @Profile("!prod")
        @Profile("prod&web")
        //! | &
        public UserRepository userRepository2(ConnectionPool pool2){
            return new UserRepository(pool2);
        }

        @Bean
        public UserRepository userRepository3(){
            ConnectionPool connectionPool1 = pool3();
            ConnectionPool connectionPool2 = pool3();
            ConnectionPool connectionPool3 = pool3();
            return new UserRepository(pool3());
        }
}
