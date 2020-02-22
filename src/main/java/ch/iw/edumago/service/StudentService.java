package ch.iw.edumago.service;

import ch.iw.edumago.model.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO create(StudentDTO it_club);

    StudentDTO findStudentById(Long id);

    List<StudentDTO> findAllStudents();

    StudentDTO update(Long anyLong, StudentDTO any);

    void deleteById(Long id);
}
