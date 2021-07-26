package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.exception.RegisterUsernameAlreadyExistsException;
import cn.yangliuqing.todolistbackend.pojo.vo.RegisterUser;
import cn.yangliuqing.todolistbackend.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

// todo: 需要进行解耦合

/**
 * 注册控制器
 *
 * @author yang
 */
@RestController
@RequestMapping("/register")
@CrossOrigin("*")
public class RegistryController {
    private final RegisterService registerService;

    public RegistryController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<String> register(@Valid RegisterUser registerUser)
            throws RegisterUsernameAlreadyExistsException {
        registerService.addUser(registerUser);
        // 返回成功结果
        return ResponseEntity.ok("创建用户完成");
    }
}
