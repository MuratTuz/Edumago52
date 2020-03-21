package ch.iw.edumago.controller;


import ch.iw.edumago.model.EnrollmentDTO;
import ch.iw.edumago.service.EnrollmentService;
import ch.iw.edumago.service.impl.DefaultEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired private EnrollmentService enrollmentService;

    @RequestMapping
    ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        return ResponseEntity.ok().body(enrollmentService.findAll());
    }


    @RequestMapping(value = "/{id}")
    ResponseEntity<EnrollmentDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(enrollmentService.findById(Long.parseLong(id)));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    EnrollmentDTO addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        return enrollmentService.create(enrollmentDTO);
    }
}
