package cn.yangliuqing.todolistbackend.service;

import cn.yangliuqing.todolistbackend.entity.Task;
import cn.yangliuqing.todolistbackend.repository.RemindRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

/** @author yang */
@Service
public class ScheduledTaskService {
    /** 任务时间靠前的在优先队列前 */
    private final PriorityQueue<Task> queue =
            new PriorityQueue<>((Task t1, Task t2) -> t1.getTime().isBefore(t2.getTime()) ? -1 : 1);

    private final EmailSenderService emailSenderService;

    final String subject = "邮件提醒服务";

    final String content = "尊敬的%s:\n\t您的任务%s已经到达提醒时间!\n\t任务详情:%s";

    public ScheduledTaskService(
            EmailSenderService emailSenderService, RemindRepository remindRepository) {
        this.emailSenderService = emailSenderService;
    }

    public void addTask(Task task) {
        queue.add(task);
    }

    /** 每一分钟检查一次任务情况 */
    @Scheduled(cron = "0 0/1 * * * *")
    public void scheduleTask() {
        if (!queue.isEmpty()) {
            // 轮询第一个任务
            var t = queue.element();
            long currentTimeMillis = System.currentTimeMillis();

            // 如果第一个任务的提醒时间超过了当前时间,触发邮件发送事件
            LocalDateTime remindTime = t.getTime();
            LocalDateTime now = LocalDateTime.now();
            if (remindTime.isAfter(now)) {
                // 发送邮件
                emailSenderService.sendTextEmail(
                        t.getToEmail(),
                        subject,
                        String.format(content, t.getUsername(), t.getTitle(), t.getDescription()));

                // 从队列中删除任务
                queue.remove();

                // 递归查看下一个任务
                scheduleTask();
            }
        }
    }
}
