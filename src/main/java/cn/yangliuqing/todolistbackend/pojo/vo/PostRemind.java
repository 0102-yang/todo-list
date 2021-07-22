package cn.yangliuqing.todolistbackend.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/** @author yang */
@Data
public class PostRemind {
    @NotBlank private Integer userId;

    @NotBlank private String title;

    private String description;

    @NotBlank private String email;

    private Integer priority;

    private LocalDateTime createTime;

    private LocalDateTime remindTime;

    private Boolean reminded;
}
