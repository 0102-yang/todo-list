package cn.yangliuqing.todolistbackend.repository;

import cn.yangliuqing.todolistbackend.pojo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRepositoryTests {
    @Autowired private UserRepository userRepository;

    @BeforeEach
    void init() {
        userRepository.deleteAll();
        User addUser = new User().setUsername("Yang").setPassword("123456").setEmail("1234");
        userRepository.save(addUser);
    }

    @Test
    void addUserTest() {
        var user = userRepository.findByUsername("Yang");
        Assert.isTrue(user != null, "Add user fail!");
    }

    @Test
    void findTest() {
        String existsUsername = "Yang";
        String notExistsUsername = "Not exist";

        var user = userRepository.findByUsername(existsUsername);
        Assert.isTrue(user != null, "Find fail!");

        boolean flag = userRepository.existsByUsername(existsUsername);
        Assert.isTrue(flag, "Exist fail!");

        boolean flag2 = userRepository.existsByUsername(notExistsUsername);
        Assert.isTrue(!flag2, "Exist fail!");

        var wrongUser = userRepository.findByUsername(notExistsUsername);
        Assert.isTrue(wrongUser == null, "Find fail!");
    }
}
