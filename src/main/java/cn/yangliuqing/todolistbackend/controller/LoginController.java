package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.pojo.vo.LoginUser;
import cn.yangliuqing.todolistbackend.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/** @author yang */
@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<String> login(@Valid LoginUser loginUser) {
        loginService.authenticate(loginUser);

        return ResponseEntity.ok("登录成功");
    }
}
