package cn.yangliuqing.todolistbackend.repository;

import cn.yangliuqing.todolistbackend.entity.Remind;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** @author yang */
@Repository
@Table("remind")
public interface RemindRepository extends CrudRepository<Remind, String> {}
