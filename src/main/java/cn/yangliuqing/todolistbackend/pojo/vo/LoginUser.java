package cn.yangliuqing.todolistbackend.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/** @author yang */
@Data
public class LoginUser {
    @NotBlank private String username;

    @NotBlank private String password;
}
