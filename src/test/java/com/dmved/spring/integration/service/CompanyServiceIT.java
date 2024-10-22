package com.dmved.spring.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dmved.spring.dto.CompanyReadDto;
import com.dmved.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//                      initializers = ConfigDataApplicationContextInitializer.class)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    @Autowired
    CompanyService companyService;

    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual ->  assertEquals(expectedResult, actual));
    }
}
