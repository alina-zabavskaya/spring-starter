package com.dmved.spring.database.repository;

import com.dmved.spring.database.pool.ConnectionPool;

public class CompanyRepository {
    ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
