package cn.yangliuqing.todolistbackend.exception;

/**
 * 用户名已存在异常
 *
 * @author yang
 */
public class UsernameAlreadyExistsException extends Exception {
    private static final String MESSAGE = "用户名已经存在";

    public UsernameAlreadyExistsException() {
        super(MESSAGE);
    }
}
