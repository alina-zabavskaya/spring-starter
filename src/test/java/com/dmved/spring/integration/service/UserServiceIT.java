package com.dmved.spring.integration.service;

import com.dmved.spring.database.pool.ConnectionPool;
import com.dmved.spring.integration.annatation.IT;
import com.dmved.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test(){
        System.out.println();
    }

    @Test
    void test2(){
        System.out.println();
    }
}
