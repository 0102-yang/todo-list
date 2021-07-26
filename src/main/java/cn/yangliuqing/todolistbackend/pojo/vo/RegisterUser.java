package cn.yangliuqing.todolistbackend.pojo.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 注册用户
 *
 * @author yang
 */
@Data
public class RegisterUser {
    @NotBlank(message = "Username can not be blank.")
    private String username;

    @NotBlank(message = "Password can not be blank.")
    private String password;

    @NotBlank(message = "Email can not be blank.")
    @Email(message = "Not a valid email address.")
    private String email;
}
