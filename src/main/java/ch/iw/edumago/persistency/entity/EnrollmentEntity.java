package ch.iw.edumago.persistency.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edu_enrollment")
@Builder
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min=3)
    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<StudentEntity> students;

    @OneToMany
    private List<CourseEntity> courses;

}
