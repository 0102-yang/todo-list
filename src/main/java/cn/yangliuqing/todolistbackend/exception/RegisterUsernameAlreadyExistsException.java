package cn.yangliuqing.todolistbackend.exception;

/**
 * 用户名已存在异常
 *
 * @author yang
 */
public class RegisterUsernameAlreadyExistsException extends CustomException {
    private static final String MESSAGE = "注册的用户名已经存在";
    private static final long serialVersionUID = -6101427712301546368L;

    public RegisterUsernameAlreadyExistsException() {
        super(MESSAGE);
    }
}
