package ch.iw.edumago.controller;


import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;



@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping
    ResponseEntity<List<StudentDTO>> getAllStudents() {
        studentService.create(StudentDTO.builder().firstName("mehmet").lastName("dogan").build());

        return ResponseEntity.ok().body(studentService.findAllStudents());
    }
}


