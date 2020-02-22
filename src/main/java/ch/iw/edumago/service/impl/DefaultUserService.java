package ch.iw.edumago.service.impl;

import ch.iw.edumago.persistency.entity.StudentEntity;
import ch.iw.edumago.persistency.repository.StudentRepository;
import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.service.StudentService;
import ch.iw.edumago.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DefaultUserService implements StudentService {


    @Autowired private StudentRepository studentRepository;

    @Override
    @Transactional
    public StudentDTO create(StudentDTO student) {

        StudentEntity studentEntity = StudentMapper.INSTANCE.toEntity(student);

        studentEntity = studentRepository.save(studentEntity);

        return StudentMapper.INSTANCE.toDto(studentEntity);
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        return null;
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        return null;
    }
}
