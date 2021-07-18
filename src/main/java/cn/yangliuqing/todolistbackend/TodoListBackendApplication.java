package cn.yangliuqing.todolistbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/** @author yang */
@SpringBootApplication
@EnableScheduling
public class TodoListBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListBackendApplication.class, args);
    }
}
