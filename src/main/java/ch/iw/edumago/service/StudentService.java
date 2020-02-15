package ch.iw.edumago.service;

import ch.iw.edumago.model.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO create(StudentDTO student);

    List<StudentDTO> getAllStudents();

}
