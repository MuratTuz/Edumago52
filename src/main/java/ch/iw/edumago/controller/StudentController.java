package ch.iw.edumago.controller;


import ch.iw.edumago.dto.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    ResponseEntity<List<StudentDTO>> getAllStudents() {

        StudentDTO mehmet = StudentDTO.builder().firstName("mehmet").lastName("dogan").build();
        StudentDTO deniz = StudentDTO.builder().firstName("deniz").lastName("tokat").build();

        return ResponseEntity.ok().body(Arrays.asList(mehmet, deniz));
    }
}
