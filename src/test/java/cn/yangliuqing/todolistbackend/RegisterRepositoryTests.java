package cn.yangliuqing.todolistbackend;

import cn.yangliuqing.todolistbackend.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterRepositoryTests {
    @Autowired private MockMvc mockMvc;

    @Autowired private UserDetailsServiceImpl userDetailsService;

    @Test
    void successfulLogin() {}
}
