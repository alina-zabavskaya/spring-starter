package com.dmved.spring.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dmved.spring.config.DatabaseProperties;
import com.dmved.spring.dto.CompanyReadDto;
import com.dmved.spring.integration.annatation.IT;
import com.dmved.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = AutowireMode.ALL)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual ->  assertEquals(expectedResult, actual));
    }
}
