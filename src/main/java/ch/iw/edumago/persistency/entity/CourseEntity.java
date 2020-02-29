package ch.iw.edumago.persistency.entity;

import lombok.*;

import javax.persistence.*;

/*
Enrollment class çalisabilsin diye bu entity i Murat olusturdu.
 */
@Getter
@Setter
@Entity
@Table(name = "edu_course")
public class CourseEntity
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
}
