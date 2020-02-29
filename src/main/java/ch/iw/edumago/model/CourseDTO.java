
package ch.iw.edumago.model;


import lombok.*;
/*
 Enrollment class çalisabilsin diye onunla iliskili bu class i Murat olusturdu.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {
    private Long id;
    private String courseName;
}
