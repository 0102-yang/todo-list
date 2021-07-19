package cn.yangliuqing.todolistbackend.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/** @author yang */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "remind")
@Accessors(chain = true)
public class Remind implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "remind_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer remindId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "remind_time")
    private LocalDateTime remindTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Remind remind = (Remind) o;

        return Objects.equals(remindId, remind.remindId);
    }

    @Override
    public int hashCode() {
        return 178679516;
    }
}
