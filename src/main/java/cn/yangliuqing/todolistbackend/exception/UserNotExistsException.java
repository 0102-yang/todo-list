package cn.yangliuqing.todolistbackend.exception;

/** @author yang */
public class UserNotExistsException extends CustomException {
    private static final String MESSAGE = "用户不存在";
    private static final long serialVersionUID = -6406938287358004305L;

    public UserNotExistsException() {
        super(MESSAGE);
    }
}
