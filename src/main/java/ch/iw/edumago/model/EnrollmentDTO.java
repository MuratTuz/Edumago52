package ch.iw.edumago.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentDTO {
    private Long id;
    private String name;
    private List<CourseDTO> courses;
    private List<StudentDTO> students;
}
