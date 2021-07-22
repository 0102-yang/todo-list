package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.exception.RegisterUsernameAlreadyExistsException;
import cn.yangliuqing.todolistbackend.pojo.entity.User;
import cn.yangliuqing.todolistbackend.pojo.vo.RegisterUser;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistryController(
            UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @PostMapping
    public ResponseEntity<String> register(@Valid RegisterUser registerUser)
            throws RegisterUsernameAlreadyExistsException {
        if (userRepository.existsByUsername(registerUser.getUsername())) {
            throw new RegisterUsernameAlreadyExistsException();
        }

        // 添加用户到数据库
        String encryptPassword = bCryptPasswordEncoder.encode(registerUser.getPassword());
        User user =
                new User()
                        .setUsername(registerUser.getUsername())
                        .setPassword(encryptPassword)
                        .setEmail(registerUser.getEmail());
        userRepository.save(user);

        // 返回成功结果
        return ResponseEntity.ok("创建用户完成");
    }
}
