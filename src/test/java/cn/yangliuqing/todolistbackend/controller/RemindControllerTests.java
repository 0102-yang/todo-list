package cn.yangliuqing.todolistbackend.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class RemindControllerTests {
    @Autowired private MockMvc mockMvc;

    @BeforeEach
    void init() throws Exception {
        MultiValueMap<String, String> userParam = new LinkedMultiValueMap<>();
        userParam.add("username", "Yang");
        userParam.add("password", "123456");
        userParam.add("email", "1234");
        mockMvc.perform(MockMvcRequestBuilders.post("/register").params(userParam));
    }

    @Test
    void testAddRemind() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userId", "1");
        params.add("title", "yang");
        params.add("email", "123456");
        mockMvc.perform(MockMvcRequestBuilders.post("/remind/1").params(params))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(MockMvcRequestBuilders.get("/remind/1"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testDelete() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userId", "1");
        params.add("title", "yang");
        params.add("email", "123456");
        mockMvc.perform(MockMvcRequestBuilders.post("/remind/1").params(params));

        mockMvc.perform(MockMvcRequestBuilders.delete("/remind/1"))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(MockMvcRequestBuilders.delete("/remind/1"))
                .andDo(MockMvcResultHandlers.print());
    }
}
