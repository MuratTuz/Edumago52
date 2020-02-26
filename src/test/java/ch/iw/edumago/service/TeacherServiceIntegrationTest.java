package ch.iw.edumago.service;

import ch.iw.edumago.TestConfiguration;
import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.RoleDTO;
import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.persistency.entity.ERole;
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

@DisplayName("Testing the Teacher's service methods")
@SpringJUnitConfig(TestConfiguration.class)
public class TeacherServiceIntegrationTest {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    @DisplayName("A new Teacher is created.")
    public void createTeacherTest() {
        final String edumago = "Edumago";

        Set<RoleDTO> roleDTOS = new HashSet<>();
        roleDTOS.add(RoleMapper.INSTANE.toDTO(roleRepository.findByName(ERole.ROLE_TEACHER)));

        TeacherDTO teacher = teacherService.create(TeacherDTO.builder()
                .firstName(edumago)
                .lastName("IT Club")
                .roles(roleDTOS)
                .build());

        Assertions.assertNotEquals(teacher, null);
        Assertions.assertNotEquals(teacher.getId(), null);
        Assertions.assertEquals(teacher.getRoles().size(), 1);
        Assertions.assertEquals(teacher.getFirstName(), edumago);
    }


    @Test
    @DisplayName("A new Teacher without a last name can not be created.")
    public void tryToCreateTeacherWithoutLastname() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            final String edumago = "Edumago";
            TeacherDTO teacherDTO = teacherService.create(TeacherDTO.builder()
                    .firstName(edumago)
                    .build());
        });
    }

    @Test
    @DisplayName("Find A Teacher by id.")
    public void findTeacherByIdTest() {
        final String edumago = "Edumago";

        Set<RoleDTO> roleDTOS = new HashSet<>();
        roleDTOS.add(RoleMapper.INSTANE.toDTO(roleRepository.findByName(ERole.ROLE_TEACHER)));

        TeacherDTO teacher = teacherService.create(TeacherDTO.builder()
                .firstName(edumago)
                .lastName("IT Club")
                .roles(roleDTOS)
                .build());

        //when
        TeacherDTO teacherDTO = teacherService.findById(teacher.getId());

        //Then
        assertNotEquals(teacherDTO, null);
        assertNotEquals(teacherDTO.getId(), null);
        assertEquals(teacherDTO.getFirstName(), "Edumago");
    }

    @Test
    @DisplayName("Not found Student with wrong id")
    public void tryToFindTeacherWithWrongId() {

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            TeacherDTO teacher = teacherService.findById(Long.valueOf(300));
        });
    }

    @Test
    @DisplayName("Not found Student with IllegalArgument")
    public void tryToFindTeacherWithIllegalArgumentId() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TeacherDTO teacher = teacherService.findById(Long.valueOf("abc"));
        });
    }

    @Test
    @DisplayName("Find All Students")
    public void findAllTeachersTest() {

        //when
        List<TeacherDTO> teacherDTOS = teacherService.findAll();

        // then
        assertNotNull(teacherDTOS);
    }

    @Test
    @DisplayName("Not found any Student")
    public void tryToFindAllTeacherNotFoundException() {
        teacherRepository.deleteAll();

        Assertions.assertThrows(NotFoundException.class, () -> {
            List<TeacherDTO> teacherDTOS = teacherService.findAll();
        });
    }
}
