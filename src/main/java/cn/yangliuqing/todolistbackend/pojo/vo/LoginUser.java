package cn.yangliuqing.todolistbackend.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/** @author yang */
@Data
public class LoginUser {
    @NotBlank(message = "Username can not be blank.")
    private String username;

    @NotBlank(message = "Password can not be blank.")
    private String password;
}
