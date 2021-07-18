package cn.yangliuqing.todolistbackend.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "remind")
public class Remind implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "remind_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String remindId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "remind_time")
    private Date remindTime;

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
