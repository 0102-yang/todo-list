package cn.yangliuqing.todolistbackend;

import cn.yangliuqing.todolistbackend.service.ScheduledTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskTests {
    @Autowired private ScheduledTaskService scheduledTaskService;

    @Test
    void test() {}
}
