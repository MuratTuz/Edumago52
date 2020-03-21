package ch.iw.edumago.controller;


import ch.iw.edumago.model.EnrollmentDTO;
import ch.iw.edumago.model.TeacherDTO;
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
    ResponseEntity<EnrollmentDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(enrollmentService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    EnrollmentDTO addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        return enrollmentService.create(enrollmentDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public EnrollmentDTO updateEnrollment(@PathVariable Long id, @RequestBody EnrollmentDTO enrollmentDTO) {
        return enrollmentService.update(id, enrollmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTeacherById(@PathVariable Long id) {
        enrollmentService.delete(id);
    }
}
