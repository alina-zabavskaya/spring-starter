package com.dmved.spring.database.repository;

import com.dmved.spring.bpp.InjectBean;
import com.dmved.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBean
    private ConnectionPool connectionPool;


}
