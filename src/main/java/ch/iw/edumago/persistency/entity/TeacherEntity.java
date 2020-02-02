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
@Table(name = "edu_teacher")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "tch_first_name")
    private String firstName;

    @NotBlank
    @Column(name = "tch_last_name")
    private String lastName;

    // todo: consider having a uuid like ssn (ahv)
    @Column(name = "tch_register_id")
    private String registerId;

    @Column(name = "tch_register_date")
    private LocalDate registerDate;
}
