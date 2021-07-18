package cn.yangliuqing.todolistbackend.repository;

import cn.yangliuqing.todolistbackend.entity.User;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;

/** @author yang */
@Table("user")
public interface UserRepository extends CrudRepository<User, String> {
    /**
     * 获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    User findUserByUsername(String username);
}
