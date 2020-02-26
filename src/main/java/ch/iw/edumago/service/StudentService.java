package ch.iw.edumago.service;

import ch.iw.edumago.model.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO create(StudentDTO student);

    List<StudentDTO> findAllStudents();

    StudentDTO findStudentById(Long id);

    StudentDTO update(Long anyLong, StudentDTO studentDTO);

    void deleteById(Long id);
}
