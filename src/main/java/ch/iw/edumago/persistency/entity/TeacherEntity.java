package ch.iw.edumago.persistency.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "edu_teacher")
@Setter
@Getter
@RequiredArgsConstructor
public class TeacherEntity extends UserEntity{

    @Builder
    public TeacherEntity(Long id, String firstName, String lastName,
                         String registerId, Timestamp registerDate, Timestamp lastUpdatedDate, Set<RoleEntity> roles) {
    }
}
