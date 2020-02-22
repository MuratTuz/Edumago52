package ch.iw.edumago.service;

import ch.iw.edumago.model.TeacherDTO;

import java.util.List;

public interface TeacherService {
    TeacherDTO create(TeacherDTO it_club);

    List<TeacherDTO> findAll();

    TeacherDTO findById(Long anyLong);

    TeacherDTO update(Long id, TeacherDTO teacherDTO);

    void deleteById(Long id);
}
