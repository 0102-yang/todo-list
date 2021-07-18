package cn.yangliuqing.todolistbackend;

import cn.yangliuqing.todolistbackend.entity.Task;
import cn.yangliuqing.todolistbackend.service.ScheduledTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TaskTests {
    @Autowired private ScheduledTaskService scheduledTaskService;

    @Test
    void test() {
        LocalDateTime l = LocalDateTime.of(2021, 7, 19, 2, 30);
        Task task = new Task("1657375983@qq.com", "Test title", "Test description", "yang", l);
        scheduledTaskService.addTask(task);
    }
}
