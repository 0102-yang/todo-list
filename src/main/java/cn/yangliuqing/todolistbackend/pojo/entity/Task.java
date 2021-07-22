package cn.yangliuqing.todolistbackend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用于定时器轮询查询的任务
 *
 * @author yang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String toEmail;

    private String title;

    private String description;

    private String username;

    private LocalDateTime time;
}
