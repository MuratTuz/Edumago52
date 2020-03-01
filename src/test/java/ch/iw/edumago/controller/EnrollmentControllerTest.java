package ch.iw.edumago.controller;

import ch.iw.edumago.model.EnrollmentDTO;
import ch.iw.edumago.service.EnrollmentService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Testing Enrollment Controller")
@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = EnrollmentController.class)
public class EnrollmentControllerTest {

/*    @InjectMocks
    private EnrollmentController enrollmentController;

    @Mock
    private EnrollmentService enrollmentService;*/

    private MockMvc mockMvc;
    EnrollmentDTO enrollmentDTO;

    @Test
    @DisplayName("Get All Enrollments")
    void findAllEnrollmentsTest() throws Exception {
        mockMvc.perform(get("/enrollments")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    @DisplayName("Get Selected Enrollment - id=1")
    void findSelectedEnrollmentTest() throws Exception {
        mockMvc.perform(get("/enrollments/1")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    @DisplayName("Post Enrollment")
    void setEnrollmentTest() throws Exception {
        //mockMvc.perform();
    }

}
