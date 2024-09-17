package com.dmved.spring.database.repository;

import com.dmved.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
