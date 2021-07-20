package cn.yangliuqing.todolistbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = TodoListBackendApplication.class)
@AutoConfigureMockMvc
public class RegisterTests {
    @Autowired private MockMvc mock;

    @Test
    void registerTest() {
        System.out.println("Hello World");
    }
}
