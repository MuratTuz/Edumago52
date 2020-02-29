package ch.iw.edumago.controller;


import ch.iw.edumago.model.EnrollmentDTO;
import ch.iw.edumago.service.impl.DefaultEnrollmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired private DefaultEnrollmentServiceImpl enrollmentService;

    @RequestMapping
    ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        EnrollmentDTO course1 = EnrollmentDTO.builder().id(1L).build();
        EnrollmentDTO course2 = EnrollmentDTO.builder().id(2L).build();

        return ResponseEntity.ok().body(Arrays.asList(course1, course2));
    }


    @RequestMapping(value = "/{selectedID}")
    ResponseEntity<EnrollmentDTO> getSelectedEnrollment(@PathVariable String selectedID) {
        EnrollmentDTO course1 = EnrollmentDTO.builder().id(Long.parseLong(selectedID)).build();
        return ResponseEntity.ok().body(course1);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    String addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        return enrollmentService.add(enrollmentDTO).toString();
    }
}
