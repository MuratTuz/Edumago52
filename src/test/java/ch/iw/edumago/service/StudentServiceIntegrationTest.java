package ch.iw.edumago.service;

import ch.iw.edumago.dto.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Testing the student's service methods")
@ExtendWith(SpringExtension.class)
public class StudentServiceIntegrationTest {

    @Autowired private StudentService studentService;

    @Test
    @DisplayName("Test student creations")
    public void createStudent() {
        StudentDTO student = studentService.create(StudentDTO.builder().firstName("it club").build());

        Assertions.assertNotEquals(student, null);
        Assertions.assertEquals(student.getFirstName(), "it club");

        // verify if the save method is called when createTodo is called too
        //verify(studentRepository, times(1)).save(any(StudentDTO.class));
    }

}



