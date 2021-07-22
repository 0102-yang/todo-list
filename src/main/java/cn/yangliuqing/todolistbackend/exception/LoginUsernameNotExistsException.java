package cn.yangliuqing.todolistbackend.exception;

/** @author yang */
public class LoginUsernameNotExistsException extends CustomException {
    private static final String MESSAGE = "登录用户名不存在";
    private static final long serialVersionUID = -8108188422568105244L;

    public LoginUsernameNotExistsException() {
        super(MESSAGE);
    }
}
