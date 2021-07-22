package cn.yangliuqing.todolistbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTests {
    @Autowired private MockMvc mockMvc;

    @Test
    void login() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/login")
                                .param("username", "")
                                .param("password", "123456"))
                .andDo(MockMvcResultHandlers.print());
    }
}
