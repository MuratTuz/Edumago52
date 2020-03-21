package ch.iw.edumago.controller;

import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.EnrollmentDTO;
import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.service.EnrollmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Testing Enrollment Controller")
@ExtendWith(MockitoExtension.class)
public class EnrollmentControllerTest {

    @InjectMocks
    private EnrollmentController enrollmentController;

    @Mock
    private EnrollmentService enrollmentService;

    private MockMvc mockMvc;
    EnrollmentDTO enrollmentDTO1, enrollmentDTO2;
    List<EnrollmentDTO> enrollmentDTOS;

    @BeforeEach
    void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(enrollmentController).build();

        enrollmentDTO1 = EnrollmentDTO.builder().name("enroll_1").build();
        enrollmentDTO2 = EnrollmentDTO.builder().name("enroll_2").build();
        //given
        enrollmentDTOS = Arrays.asList(enrollmentDTO1,enrollmentDTO2);
    }

    @Test
    @DisplayName("Get All Enrollments")
    void findAllEnrollmentsTest() throws Exception {



        when(enrollmentService.findAll()).thenReturn(enrollmentDTOS);

        mockMvc.perform(get("/enrollments")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("Get Selected Enrollment - name = enroll_1")
    void findSelectedEnrollmentTest() throws Exception {
        //given
        when(enrollmentService.findById(1L)).thenReturn(enrollmentDTO1);

        mockMvc.perform(get("/enrollments/1")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("enroll_1"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Create new Enrollment - Post Enrollment")
    void createEnrollmentTest() throws Exception {
        //given
        when(enrollmentService.create(any(EnrollmentDTO.class))).thenReturn(enrollmentDTO1);

        //whenThen
        mockMvc.perform(post("/enrollments")
               .content(asJsonString(enrollmentDTO1))
               .contentType(MediaType.APPLICATION_JSON)
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.name").value("enroll_1"));
    }

    @Test
    @DisplayName("Get Enrollment ById NotFoundException")
    void findEnrollmentByIdNotFoundExceptionTest() throws Exception {
        //given
        when(enrollmentService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/enrollments/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Get Enrollment ById BadRequestException")
    void findEnrollmentByIdBadRequestExceptionTest() throws Exception {
        //givenThen
        mockMvc.perform(get("/enrollments/murat"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Update Enrollment")
    void updateEnrollmentTest() throws Exception {
        //given
        when(enrollmentService.update(anyLong(), any(EnrollmentDTO.class))).thenReturn(enrollmentDTO1);

        //whenThen
        mockMvc.perform(put("/enrollments/{id}", 2)
                .content(asJsonString(enrollmentDTO1))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.name").value("enroll_1"));
    }

    @Test
    @DisplayName("Delete Enrollment By id")
    void deleteEnrollmentByIdTest() throws Exception {
        mockMvc.perform(delete("/enrollments/{id}", 1) )
                .andExpect(status().isAccepted());
    }

}
