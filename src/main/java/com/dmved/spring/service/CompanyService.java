package com.dmved.spring.service;

import com.dmved.spring.database.entity.Company;
import com.dmved.spring.database.repository.CrudRepository;
import com.dmved.spring.dto.CompanyReadDto;
import com.dmved.spring.listener.entity.AccessType;
import com.dmved.spring.listener.entity.EntityEvent;
import java.util.Optional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(UserService userService, CrudRepository companyRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.userService = userService;
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                                .map(entity -> {
                                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                                    return new CompanyReadDto(entity.id());
                                });

    }
}
