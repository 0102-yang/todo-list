package cn.yangliuqing.todolistbackend.exception;

/** @author yang */
public class RemindNotExistsException extends CustomException {
    private static final String MESSAGE = "要找的提醒不存在";
    private static final long serialVersionUID = -1705466563781566962L;

    public RemindNotExistsException() {
        super(MESSAGE);
    }
}
