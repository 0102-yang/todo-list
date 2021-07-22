package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.exception.UserNotExistsException;
import cn.yangliuqing.todolistbackend.pojo.vo.UserInfo;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author yang */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> userInfo(@PathVariable(name = "id") Integer id) {
        var user = userRepository.findById(id).orElseThrow(UserNotExistsException::new);

        UserInfo userInfo =
                new UserInfo().setUsername(user.getUsername()).setEmail(user.getEmail());

        return ResponseEntity.ok(userInfo);
    }
}
