package cn.yangliuqing.todolistbackend.repository;

import cn.yangliuqing.todolistbackend.pojo.entity.User;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** @author yang */
@Repository
@Table("user")
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * 获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    User findByUsername(String username);

    /**
     * 判断是否存在该用户名
     *
     * @param username 用户名
     * @return true则存在
     */
    boolean existsByUsername(String username);
}
