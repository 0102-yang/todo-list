package cn.yangliuqing.todolistbackend.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册用户
 *
 * @author yang
 */
@Data
public class RegisterUser {
    @NotBlank private String username;

    @NotBlank private String password;

    @NotBlank private String email;
}
