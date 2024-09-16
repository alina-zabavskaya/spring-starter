package com.dmved.spring.service;

import com.dmved.spring.database.entity.Company;
import com.dmved.spring.database.repository.CompanyRepository;
import com.dmved.spring.database.repository.CrudRepository;
import com.dmved.spring.database.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository, CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
