package cn.yangliuqing.todolistbackend.controller;

import cn.yangliuqing.todolistbackend.exception.RemindNotExistsException;
import cn.yangliuqing.todolistbackend.exception.UserNotExistsException;
import cn.yangliuqing.todolistbackend.pojo.entity.Remind;
import cn.yangliuqing.todolistbackend.pojo.vo.PostRemind;
import cn.yangliuqing.todolistbackend.repository.RemindRepository;
import cn.yangliuqing.todolistbackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/** @author yang */
@RestController
@RequestMapping
public class RemindController {
    private final UserRepository userRepository;

    private final RemindRepository remindRepository;

    public RemindController(UserRepository userRepository, RemindRepository remindRepository) {
        this.userRepository = userRepository;
        this.remindRepository = remindRepository;
    }

    @GetMapping("/remind/{id}")
    public ResponseEntity<Remind> getRemind(@PathVariable(name = "id") Integer id) {
        var remind = remindRepository.findById(id).orElseThrow(RemindNotExistsException::new);
        return ResponseEntity.ok(remind);
    }

    @PostMapping("/remind")
    public ResponseEntity<String> postRemindToUser(@Valid PostRemind postRemind) {
        if (!userRepository.existsById(postRemind.getUserId())) {
            throw new UserNotExistsException();
        }

        remindRepository.save(postRemind.getRemind());
        return ResponseEntity.accepted().body("资源已经创建");
    }

    @GetMapping("/reminds/{userId}")
    public ResponseEntity<List<Remind>> getRemindsByUserId(
            @PathVariable(name = "userId") Integer userId) {
        var reminds = remindRepository.findAllByUserId(userId);
        return ResponseEntity.ok(reminds);
    }

    @DeleteMapping("/remind/{remindId}")
    public ResponseEntity<String> deleteRemindById(
            @PathVariable(name = "remindId") Integer remindId) {
        if (!remindRepository.existsById(remindId)) {
            throw new RemindNotExistsException();
        }

        remindRepository.deleteById(remindId);
        return ResponseEntity.noContent().build();
    }
}
