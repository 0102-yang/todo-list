package cn.yangliuqing.todolistbackend.service;

import cn.yangliuqing.todolistbackend.exception.LoginUsernameNotExistsException;
import cn.yangliuqing.todolistbackend.pojo.vo.LoginUser;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/** @author yang */
@Service
public class LoginService {
    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    public LoginService(
            AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public void authenticate(LoginUser loginUser) {
        if (!userRepository.existsByUsername(loginUser.getUsername())) {
            throw new LoginUsernameNotExistsException();
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(), loginUser.getPassword()));
    }
}
