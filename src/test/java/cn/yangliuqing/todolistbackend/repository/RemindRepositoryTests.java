package cn.yangliuqing.todolistbackend.repository;

import cn.yangliuqing.todolistbackend.pojo.entity.Remind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@SpringBootTest
public class RemindRepositoryTests {
    @Autowired private RemindRepository remindRepository;

    @Autowired private UserRepository userRepository;

    @BeforeEach
    void init() {
        LocalDateTime createTime = LocalDateTime.of(2020, 1, 23, 8, 20);
        LocalDateTime remindTime = LocalDateTime.of(2020, 1, 28, 8, 21);
        Remind remind =
                new Remind().setUserId(80).setDescription("World").setRemindTime(remindTime);
        remindRepository.save(remind);
    }

    @Test
    void testLocalDateTime() {
        var list =
                remindRepository.findAllByRemindTimeBeforeAndCompleteFlag(
                        LocalDateTime.now(), Boolean.FALSE);
        Assert.isTrue(list.size() > 0, "方法执行错误");
        System.out.println(list);
    }

    @Test
    void updateTest() {
        remindRepository.updateCompleteFlagByRemindId(Boolean.TRUE, 1);
        var remind = remindRepository.findById(1).get();
    }
}
