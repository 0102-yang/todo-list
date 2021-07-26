package cn.yangliuqing.todolistbackend.service;

import cn.yangliuqing.todolistbackend.pojo.entity.Remind;
import cn.yangliuqing.todolistbackend.pojo.entity.User;
import cn.yangliuqing.todolistbackend.repository.RemindRepository;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** @author yang */
@Service
@Slf4j
public class ScheduledTaskService {
    private final UserRepository userRepository;

    private final RemindRepository remindRepository;

    private final EmailSenderService emailSenderService;

    final String SUBJECT = "邮件提醒服务";

    final String CONTENT = "尊敬的%s:\n    您的任务'%s'已经到达提醒时间! 时间为%s";

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
        log.info(
                "Add a remind task, userId: "
                        + remind.getUserId()
                        + " remindId: "
                        + remind.getRemindId());
    }

    /**
     * 删除一个任务
     *
     * @param remindId 任务的id
     */
    public void deleteTask(Integer remindId) {
        remindRepository.deleteById(remindId);
        log.info("Safely delete a remind, id: " + remindId);
    }

    /** 每一分钟检查一次任务情况 */
    @Scheduled(cron = "1 0/1 * * * *")
    public void scheduleTask() {
        LocalDateTime now = LocalDateTime.now();
        var list = remindRepository.findAllByRemindTimeBeforeAndCompleteFlag(now, Boolean.FALSE);
        list.forEach(this::wrapEmailAndSendEmail);
    }

    /**
     * 包装Email消息以及发送Email消息
     *
     * @param remind 发送的事件
     */
    private void wrapEmailAndSendEmail(Remind remind) {
        // 将事件更新为已完成状态
        remindRepository.updateCompleteFlagByRemindId(Boolean.TRUE, remind.getRemindId());

        // 发送邮件
        var user = userRepository.findById(remind.getUserId()).orElse(new User());
        String toEmail = user.getEmail();
        String content =
                formatEmailContent(
                        user.getUsername(), remind.getDescription(), remind.getRemindTime());
        emailSenderService.sendTextEmail(toEmail, SUBJECT, content);
        log.info(
                "Send email complete, target user: "
                        + toEmail
                        + " remind info: "
                        + remind.getDescription());
    }

    private String formatEmailContent(String username, String description, LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分");
        return String.format(CONTENT, username, description, formatter.format(time));
    }
}
