package cn.yangliuqing.todolistbackend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderServiceTests {
    @Autowired private EmailSenderService emailSenderService;

    @Test
    void sendTest() {
        emailSenderService.sendTextEmail("1657375983@qq.com", "邮件测试", "\tThis is a test message.");
    }
}
