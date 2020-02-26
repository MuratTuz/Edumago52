package ch.iw.edumago.controller;

import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.service.TeacherService;
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

@DisplayName("Testing Teacher Controller")
@ExtendWith(MockitoExtension.class)
public class TeacherControllerTest {

    @InjectMocks
    private TeacherController teacherController;

    @Mock
    private TeacherService teacherService;

    private MockMvc mockMvc;

    TeacherDTO teacherDTO;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(teacherController)
               // .setControllerAdvice(new ControllerExceptionHandler())
                .build();

        teacherDTO = TeacherDTO.builder().firstName("Erdal")
                                .lastName("xxx").build();
    }

    @Test
    @DisplayName("Get All Teachers")
    void findAllTeachersTest() throws Exception {
        //given
        List<TeacherDTO> teacherDTOS = Arrays.asList(teacherDTO);

        when(teacherService.findAll()).thenReturn(teacherDTOS);

        //whenThen
        mockMvc.perform(get("/teachers")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    @DisplayName("Get Teacher ById")
    void findTeacherByIdTest() throws Exception {
        //given
        when(teacherService.findById(anyLong())).thenReturn(teacherDTO);

        //whenThen
        mockMvc.perform(get("/teachers/{id}", 2)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Erdal"));
    }

    @Test
    @DisplayName("Get Teacher ById NotFoundException")
    void findTeacherByIdNotFoundExceptionTest() throws Exception {
        //given
        when(teacherService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/teachers/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Get Teacher ById BadRequestException")
    void findTeacherByIdBadRequestExceptionTest() throws Exception {
        //givenThen
        mockMvc.perform(get("/teachers/abc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Create new Teacher")
    void createTeacherTest() throws Exception {
        //given
        when(teacherService.create(any(TeacherDTO.class))).thenReturn(teacherDTO);

        //whenThen
        mockMvc.perform(post("/teachers")
                .content(asJsonString(teacherDTO))
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
    @DisplayName("Update Teacher")
    void updateTeacherTest() throws Exception {
        //given
        when(teacherService.update(anyLong(), any(TeacherDTO.class))).thenReturn(teacherDTO);

        //whenThen
        mockMvc.perform(put("/teachers/{id}", 2)
                .content(asJsonString(teacherDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.firstName").value("Erdal"));
    }

    @Test
    @DisplayName("Delete Teacher ById")
    void deleteTeacherByIdTest() throws Exception {
        mockMvc.perform(delete("/teachers/{id}", 1) )
                .andExpect(status().isAccepted());
    }
}
