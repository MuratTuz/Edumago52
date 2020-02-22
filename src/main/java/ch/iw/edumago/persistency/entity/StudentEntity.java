package ch.iw.edumago.persistency.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "edu_student")
public class StudentEntity extends UserEntity {

    @Builder
    public StudentEntity(Long id, String firstName, String lastName,
                      String registerId, Timestamp registerDate, Timestamp lastUpdatedDate, Set<RoleEntity> roles) {
    }
}
