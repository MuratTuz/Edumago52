package ch.iw.edumago.controller;

import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {

        this.teacherService = teacherService;
    }

    @ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        return ResponseEntity.ok().body(teacherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.create(teacherDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TeacherDTO updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        return teacherService.update(id, teacherDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteById(id);
    }
}
