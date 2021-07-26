package cn.yangliuqing.todolistbackend.pojo.vo;

import cn.yangliuqing.todolistbackend.pojo.entity.Remind;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/** @author yang */
@Data
public class PostRemind {
    @NotNull(message = "Must belong to a user.")
    private Integer userId;

    @NotBlank(message = "Must have a description.")
    private String description;

    private Integer priority;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime remindTime;

    public Remind getRemind() {
        return new Remind()
                .setUserId(userId)
                .setDescription(description)
                .setRemindTime(remindTime)
                .setPriority(priority);
    }
}
