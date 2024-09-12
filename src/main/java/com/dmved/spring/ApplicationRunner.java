package com.dmved.spring;

import com.dmved.spring.database.pool.ConnectionPool;
import com.dmved.spring.database.repository.CompanyRepository;
import com.dmved.spring.database.repository.UserRepository;
import com.dmved.spring.ioc.Container;
import com.dmved.spring.service.UserService;

public class ApplicationRunner {

    public static void main(String[] args) {
        Container container = new Container();

//        ConnectionPool connectionPool = new ConnectionPool();
//        UserRepository userRepository = new UserRepository(connectionPool);
//        CompanyRepository companyRepository = new CompanyRepository(connectionPool);
//        UserService userService = new UserService(userRepository, companyRepository);

//        ConnectionPool connectionPool = container.get(ConnectionPool.class);
//        UserRepository userRepository = container.get(UserRepository.class);
//        CompanyRepository companyRepository = container.get(CompanyRepository.class);
        UserService userService = container.get(UserService.class);
        //todo userService use
    }
}