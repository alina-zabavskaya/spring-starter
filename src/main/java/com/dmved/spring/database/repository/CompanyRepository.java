package com.dmved.spring.database.repository;

import com.dmved.spring.bpp.Auditing;
import com.dmved.spring.bpp.InjectBean;
import com.dmved.spring.bpp.Transaction;
import com.dmved.spring.database.entity.Company;
import com.dmved.spring.database.pool.ConnectionPool;
import java.util.Optional;
import javax.annotation.PostConstruct;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository <Integer, Company> {

    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init(){
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method.....");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method......");
    }
}
