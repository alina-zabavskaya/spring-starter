package com.dmved.spring.service;

import com.dmved.spring.database.entity.Company;
import com.dmved.spring.database.repository.CrudRepository;
import com.dmved.spring.dto.CompanyReadDto;
import com.dmved.spring.listener.entity.AccessType;
import com.dmved.spring.listener.entity.EntityEvent;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                                .map(entity -> {
                                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                                    return new CompanyReadDto(entity.id());
                                });

    }
}
