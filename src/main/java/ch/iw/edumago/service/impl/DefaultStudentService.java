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
import java.util.stream.Collectors;

@Service
public class DefaultStudentService implements StudentService {

    private final StudentRepository studentRepository;

    public DefaultStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentDTO create(StudentDTO student) {
        StudentEntity studentEntity = StudentMapper.INSTANCE.toEntity(student);
        studentEntity = studentRepository.save(studentEntity);

        return StudentMapper.INSTANCE.toDto(studentEntity);
    }

    public List<StudentDTO> getAllStudents(){
        return studentRepository.findAll().stream().map(StudentMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
}
