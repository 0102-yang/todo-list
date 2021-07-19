package cn.yangliuqing.todolistbackend.service;

import cn.yangliuqing.todolistbackend.entity.Remind;
import cn.yangliuqing.todolistbackend.entity.User;
import cn.yangliuqing.todolistbackend.repository.RemindRepository;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/** @author yang */
@Service
@Slf4j
public class ScheduledTaskService {
    private final UserRepository userRepository;

    private final RemindRepository remindRepository;

    private final EmailSenderService emailSenderService;

    final String SUBJECT = "邮件提醒服务";

    final String CONTENT = "尊敬的%s:\n\t您的任务%s已经到达提醒时间!\n\t任务详情:%s";

    public ScheduledTaskService(
            EmailSenderService emailSenderService,
            RemindRepository remindRepository,
            UserRepository userRepository) {
        this.emailSenderService = emailSenderService;
        this.userRepository = userRepository;
        this.remindRepository = remindRepository;
    }

    /**
     * 添加新的任务
     *
     * @param remind 任务
     */
    public void addTask(Remind remind) {
        remindRepository.save(remind);
        log.info("已添加新的提醒任务, userId: " + remind.getUserId() + " remindId: " + remind.getRemindId());
    }

    /**
     * 删除一个任务
     *
     * @param remindId 任务的id
     */
    public void deleteTask(Integer remindId) {
        remindRepository.deleteById(remindId);
        log.info("Safe delete a remind, id: " + remindId);
    }

    /** 每一分钟检查一次任务情况 */
    @Scheduled(cron = "0 0/1 * * * *")
    public void scheduleTask() {
        LocalDateTime now = LocalDateTime.now();
        var list = remindRepository.findAllByRemindTimeBefore(now);
        list.forEach(this::wrapEmailAndSendEmail);
    }

    /**
     * 包装Email消息以及发送Email消息
     *
     * @param remind 发送的事件
     */
    private void wrapEmailAndSendEmail(Remind remind) {
        var user = userRepository.findById(remind.getUserId()).orElse(new User());
        String toEmail = remind.getEmail();
        String content =
                String.format(
                        CONTENT, user.getUsername(), remind.getTitle(), remind.getDescription());
        emailSenderService.sendTextEmail(toEmail, SUBJECT, content);
        log.info("已发送提醒邮件,目标用户" + toEmail + " 事件标题" + remind.getTitle());
    }
}
