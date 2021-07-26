package cn.yangliuqing.todolistbackend.service;

import cn.yangliuqing.todolistbackend.exception.RegisterUsernameAlreadyExistsException;
import cn.yangliuqing.todolistbackend.pojo.entity.User;
import cn.yangliuqing.todolistbackend.pojo.vo.RegisterUser;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/** @author yang */
@Service
public class RegisterService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterService(
            UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void addUser(RegisterUser user) {
        User newUser = new User();

        // 检查用户名唯一性
        String username = user.getUsername();
        if (userRepository.existsByUsername(username)) {
            throw new RegisterUsernameAlreadyExistsException();
        }

        // 加密原始密码
        String rawPassword = user.getPassword();
        String encryptedPassword = bCryptPasswordEncoder.encode(rawPassword);

        newUser.setUsername(username).setPassword(encryptedPassword).setEmail(user.getEmail());
        userRepository.save(newUser);
    }
}
