package ch.iw.edumago.service;

import ch.iw.edumago.TestConfiguration;
import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.persistency.entity.StudentEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@DisplayName("Testing the student's service methods")
@SpringJUnitConfig(TestConfiguration.class)
public class StudentServiceIntegrationTest {

    @Autowired private StudentService studentService;

    @Test
    @DisplayName("A new student is created.")
    public void createStudent() {
        final String edumago = "Edumago";
        StudentDTO student = studentService.create(StudentDTO.builder()
                                                        .firstName(edumago)
                                                        .lastName("IT Club")
                                                        .build());

        Assertions.assertNotEquals(student, null);
        Assertions.assertNotEquals(student.getId(), null);
        Assertions.assertEquals(student.getFirstName(), edumago);
    }

    @Test
    @DisplayName("A new student without a last name can not be created.")
    public void tryToCreateStudentWithoutLastname() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            final String edumago = "Edumago";
            StudentDTO student = studentService.create(StudentDTO.builder()
                    .firstName(edumago)
                    .build());
        });
    }

}



