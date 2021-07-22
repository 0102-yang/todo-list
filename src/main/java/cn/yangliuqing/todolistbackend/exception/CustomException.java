package cn.yangliuqing.todolistbackend.exception;

/** @author yang */
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1861792753957852116L;

    public CustomException(String message) {
        super(message);
    }
}
