package ch.iw.edumago.controller;

import ch.iw.edumago.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Testing Student Controller")
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean StudentService studentService;

    @Test
    @DisplayName("Get All Students")
    void findAllStudentsTest() throws Exception {
        mockMvc.perform(get("/students")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }
}
