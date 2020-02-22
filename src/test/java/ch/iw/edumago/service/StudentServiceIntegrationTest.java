package ch.iw.edumago.service;

import ch.iw.edumago.TestConfiguration;
import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.RoleDTO;
import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.persistency.entity.ERole;
import ch.iw.edumago.persistency.entity.RoleEntity;
import ch.iw.edumago.persistency.repository.RoleRepository;
import ch.iw.edumago.service.mapper.RoleMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing the student's service methods")
@SpringJUnitConfig(TestConfiguration.class)
public class StudentServiceIntegrationTest {

    @Qualifier("defaultStudentServiceImpl") // due to DefaultUserService implement StudentService ...
    @Autowired
    private StudentService studentService;

    @Autowired
    private RoleRepository roleRepository;

    private StudentDTO student;

    @BeforeEach
    void setup() {
        RoleEntity roleStudent = RoleEntity.builder().name(ERole.ROLE_STUDENT).build();
        RoleEntity roleTeacher = RoleEntity.builder().name(ERole.ROLE_TEACHER).build();
        roleRepository.saveAll(Arrays.asList(roleStudent, roleTeacher));

        createStudentDTO();
    }

    private void createStudentDTO() {
        final String edumago = "Edumago";

        Set<RoleDTO> roleDTOS = new HashSet<>();
        roleDTOS.add(RoleMapper.INSTANE.toDTO(roleRepository.findByName("ROLE_STUDENT")));

        student = studentService.create(StudentDTO.builder()
                .firstName(edumago)
                .lastName("IT Club")
                .roles(roleDTOS)
                .build());
    }

    @Test
    @DisplayName("A new student is created.")
    public void createStudent() {
        final String edumago = "Edumago";

        Assertions.assertNotEquals(student, null);
        Assertions.assertNotEquals(student.getId(), null);
        Assertions.assertEquals(student.getRoles().size(), 1);
        assertEquals(student.getFirstName(), edumago);
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

    @Test
    @DisplayName("A student by id.")
    public void findStudentByIdTest() {
        //when
        StudentDTO studentDTO = studentService.findStudentById(student.getId());

        //Then
        assertNotEquals(studentDTO, null);
        assertNotEquals(studentDTO.getId(), null);
        assertEquals(studentDTO.getFirstName(), "Edumago");
    }

    @Test
    @DisplayName("Not found Student with wrong id")
    public void tryToFindStudentWithWrongId() {

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            StudentDTO student = studentService.findStudentById(Long.valueOf(390));
        });
    }

    @Test
    @DisplayName("Not found Student with IllegalArgument")
    public void tryToFindStudentWithIllegalArgumentId() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StudentDTO student = studentService.findStudentById(Long.valueOf("abc"));
        });
    }

    @Test
    @DisplayName("Find All Students")
    public void findAllStudentsTest() {
        //when
        List<StudentDTO> studentDTOS = studentService.findAllStudents();

        // then
        assertNotNull(studentDTOS);
    }

    @Test
    @DisplayName("Not found any Student")
    public void tryToFindAllStudentNotFoundException() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            List<StudentDTO> studentDTOS = studentService.findAllStudents();
        });
    }
}



