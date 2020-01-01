package ch.iw.edumago.persistency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edu_student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min=3)
    //@Pattern(regexp="emailpatterni")
    @Column(name = "std_first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min=3)
    @Column(name = "std_last_name")
    private String lastName;

    @Column(name = "std_register_id")
    private String registerId;

    @Column(name = "std_register_date")
    private LocalDate registerDate;

}
