package com.example.demo;

import com.example.demo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @MockBean
    private UserService userService;

    @Test
    void contextLoads() {
    }

}
