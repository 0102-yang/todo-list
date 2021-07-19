package cn.yangliuqing.todolistbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;

/** @author yang */
@SpringBootApplication
@EnableScheduling
@EntityScan(basePackageClasses = {TodoListBackendApplication.class, Jsr310JpaConverters.class})
public class TodoListBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListBackendApplication.class, args);
    }
}
