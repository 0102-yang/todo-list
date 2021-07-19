package cn.yangliuqing.todolistbackend.repository;

import cn.yangliuqing.todolistbackend.entity.Remind;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/** @author yang */
@Repository
@Table("remind")
public interface RemindRepository extends CrudRepository<Remind, Integer> {
    /**
     * 返回比指定提醒时间更前的提醒任务
     *
     * @param remindTime 时间
     * @return 所有任务
     */
    List<Remind> findAllByRemindTimeBefore(LocalDateTime remindTime);
}
