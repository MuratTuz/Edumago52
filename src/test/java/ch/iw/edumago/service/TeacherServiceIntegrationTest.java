package ch.iw.edumago.service;

import ch.iw.edumago.TestConfiguration;
import ch.iw.edumago.model.TeacherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@DisplayName("Testing the Teacher's service methods")
@SpringJUnitConfig(TestConfiguration.class)
public class TeacherServiceIntegrationTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    @DisplayName("A new Teacher is created.")
    public void createTeacher() {
        final String edumago = "Edumago";
        TeacherDTO teacher = teacherService.create(TeacherDTO.builder()
                .firstName(edumago)
                .lastName("IT Club")
                .build());

        Assertions.assertNotEquals(teacher, null);
        Assertions.assertNotEquals(teacher.getId(), null);
        Assertions.assertEquals(teacher.getFirstName(), edumago);
    }
}
