package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.exception.UsernameAlreadyExistsException;
import cn.yangliuqing.todolistbackend.pojo.result.AjaxResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author yang
 */
@RestControllerAdvice
public class UnifiedExceptionHandler {
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<AjaxResult> handleException(Exception e) {
        AjaxResult ajaxResult = AjaxResult.error(-1, e.getMessage());
        return ResponseEntity.ok(ajaxResult);
    }
}
