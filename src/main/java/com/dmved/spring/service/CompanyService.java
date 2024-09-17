package com.dmved.spring.service;

import com.dmved.spring.database.entity.Company;
import com.dmved.spring.database.repository.CrudRepository;
import com.dmved.spring.dto.CompanyReadDto;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;

    public CompanyService(UserService userService, CrudRepository companyRepository) {
        this.userService = userService;
        this.companyRepository = companyRepository;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                                .map(entity -> new CompanyReadDto(entity.id()));

    }
}
