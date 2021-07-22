package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author yang
 */
@RestControllerAdvice
public class UnifiedExceptionHandler {
    /**
     * 处理额外的参数校验错误
     *
     * @param e 异常
     * @return 400 http返回结果
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(Exception e) {
        return handle(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    /**
     * 处理内置的基于注解的异常
     *
     * @param e 异常
     * @return 400 http返回结果
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleBindException(BindException e) {
        String message = "用户名或密码为空或者校验失败";
        return handle(HttpStatus.BAD_REQUEST, message);
    }

    /**
     * 处理认证失败的异常
     *
     * @param e 异常
     * @return 400 http返回结果
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException e) {
        String message = "密码错误";
        return handle(HttpStatus.BAD_REQUEST, message);
    }

    private ResponseEntity<String> handle(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(message);
    }
}
