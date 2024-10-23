package com.dmved.spring.database.repository;

import com.dmved.spring.bpp.Auditing;
import com.dmved.spring.bpp.Transaction;
import com.dmved.spring.database.entity.Company;
import com.dmved.spring.database.pool.ConnectionPool;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Slf4j
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
@Transaction
@Auditing
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository <Integer, Company> {

    private final ConnectionPool pool1;
    private final List<ConnectionPool> connectionPools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init(){
        log.warn("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        log.info("findById method.....");
        return Optional.of(new Company(id, null, Collections.EMPTY_MAP));
    }

    @Override
    public void delete(Company entity) {
        log.info("delete method......");
    }
}
