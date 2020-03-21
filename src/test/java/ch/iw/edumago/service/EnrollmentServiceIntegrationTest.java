package ch.iw.edumago.service;

import ch.iw.edumago.TestConfiguration;
import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.RoleDTO;
import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.persistency.entity.ERole;
import ch.iw.edumago.persistency.repository.EnrollmentRepository;
import ch.iw.edumago.persistency.repository.RoleRepository;
import ch.iw.edumago.persistency.repository.TeacherRepository;
import ch.iw.edumago.service.mapper.RoleMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Enrollment services Tests")
@SpringJUnitConfig(TestConfiguration.class)
public class EnrollmentServiceIntegrationTest {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Test
    @DisplayName("A new Enrollment is created.")
    public void createEnrollmentTest() {


    }


    @Test
    @DisplayName("A new Teacher without a last name can not be created.")
    public void tryToCreateTeacherWithoutLastname() {


    }

    @Test
    @DisplayName("Find A Teacher by id.")
    public void findTeacherByIdTest() {

    }

    @Test
    @DisplayName("Not found Student with wrong id")
    public void tryToFindTeacherWithWrongId() {

    }

    @Test
    @DisplayName("Not found Student with IllegalArgument")
    public void tryToFindTeacherWithIllegalArgumentId() {

    }

    @Test
    @DisplayName("Find All Students")
    public void findAllTeachersTest() {

    }

    @Test
    @DisplayName("Not found any Student")
    public void tryToFindAllTeacherNotFoundException() {

    }
}
