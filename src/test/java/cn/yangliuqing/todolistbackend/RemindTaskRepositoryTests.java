package cn.yangliuqing.todolistbackend;

import cn.yangliuqing.todolistbackend.pojo.entity.Remind;
import cn.yangliuqing.todolistbackend.repository.RemindRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@SpringBootTest
public class RemindTaskRepositoryTests {
    @Autowired private RemindRepository remindRepository;

    @Test
    void testLocalDateTime() {
        LocalDateTime createTime = LocalDateTime.of(2020, 1, 23, 8, 20);
        LocalDateTime remindTime = LocalDateTime.of(2020, 1, 28, 8, 21);
        Remind remind =
                new Remind()
                        .setTitle("Hello")
                        .setUserId(1)
                        .setDescription("World")
                        .setCreateTime(createTime)
                        .setRemindTime(remindTime)
                        .setEmail("1155");
        remindRepository.save(remind);

        LocalDateTime now = LocalDateTime.now();
        var res = remindRepository.findAllByRemindTimeBefore(now);
        Assert.isTrue(res.size() > 0, "查找不到比指定时间更早的数据");
    }
}
