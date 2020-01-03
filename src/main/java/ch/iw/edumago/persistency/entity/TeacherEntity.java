package ch.iw.edumago.persistency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "teacher")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty
    @Column(name = "teacherName")
    private String firstName;

    @NotBlank
    private String lastName;
    private String registerId;
    private LocalDate registerDate;
}
