package ch.iw.edumago.controller;

import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Testing Student Controller")
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController)
                // .setControllerAdvice(new ControllerExceptionHandler())
                .build();

        studentDTO = StudentDTO.builder().firstName("Erdal")
                .lastName("xxx").build();
    }

    @Test
    @DisplayName("Get All Students")
    void findAllStudentsTest() throws Exception {
        //given
        List<StudentDTO> studentDTOS = Arrays.asList(studentDTO);

        when(studentService.findAllStudents()).thenReturn(studentDTOS);

        //whenThen
        mockMvc.perform(get("/students")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    @DisplayName("Get Student ById")
    void findStudentByIdTest() throws Exception {
        //given
        when(studentService.findStudentById(anyLong())).thenReturn(studentDTO);

        //whenThen
        mockMvc.perform(get("/students/{id}", 2)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Erdal"));
    }

    @Test
    @DisplayName("Get Student ById NotFoundException")
    void findStudentByIdNotFoundExceptionTest() throws Exception {
        //given
        when(studentService.findStudentById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Get Student ById BadRequestException")
    void findStudentByIdBadRequestExceptionTest() throws Exception {
        //givenThen
        mockMvc.perform(get("/students/abc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Create new Student")
    void createStudentTest() throws Exception {
        //given
        when(studentService.create(any(StudentDTO.class))).thenReturn(studentDTO);

        //whenThen
        mockMvc.perform(post("/students")
                .content(asJsonString(studentDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Erdal"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Update Student")
    void updateStudentTest() throws Exception {
        //given
        when(studentService.update(anyLong(), any(StudentDTO.class))).thenReturn(studentDTO);

        //whenThen
        mockMvc.perform(put("/students/{id}", 2)
                .content(asJsonString(studentDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.firstName").value("Erdal"));
    }

    @Test
    @DisplayName("Delete Student ById")
    void deleteStudentByIdTest() throws Exception {
        mockMvc.perform(delete("/students/{id}", 1) )
                .andExpect(status().isAccepted());
    }
}
