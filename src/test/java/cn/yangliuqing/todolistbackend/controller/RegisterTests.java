package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.TodoListBackendApplication;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest(classes = TodoListBackendApplication.class)
@AutoConfigureMockMvc
public class RegisterTests {
    @Autowired private MockMvc mock;

    @Autowired private UserRepository userRepository;

    @Test
    void registerTest() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "Yang");
        params.add("password", "123456");
        params.add("email", "123456");
        mock.perform(MockMvcRequestBuilders.post("/register").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk());

        var user = userRepository.findByUsername("Yang");
        System.out.println(user.toString());

        mock.perform(MockMvcRequestBuilders.post("/register").params(params))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }
}
