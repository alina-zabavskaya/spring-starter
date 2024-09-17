package com.dmved.spring.service;

import com.dmved.spring.database.entity.Company;
import com.dmved.spring.database.repository.CrudRepository;
import com.dmved.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

}
