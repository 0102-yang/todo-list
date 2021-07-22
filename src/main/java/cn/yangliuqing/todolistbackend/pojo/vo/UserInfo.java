package cn.yangliuqing.todolistbackend.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/** @author yang */
@Data
@Accessors(chain = true)
public class UserInfo {
    private String username;

    private String email;
}
