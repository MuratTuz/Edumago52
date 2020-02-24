package ch.iw.edumago.service.impl;

import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.persistency.repository.StudentRepository;
import ch.iw.edumago.service.StudentService;
import ch.iw.edumago.service.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DefaultStudentService implements StudentService {

    private final StudentRepository studentRepository;

    public DefaultStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO create(StudentDTO it_club) {
        return StudentMapper.INSTANCE.toDto(studentRepository.save(StudentMapper.INSTANCE.toEntity(it_club)));
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        /*
        if (!studentRepository.findById(id).isPresent())
            throw new NotFoundException("There is not Student who has id:" + id);
         */
        try {
            return studentRepository.findById(id)
                    .map(studentEntity ->
                            StudentMapper.INSTANCE.toDto(studentEntity)).get();
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("There is not Student who has id:" + id);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("There is not Student who has id:" + id);
        }
    }

    @Override
    public List<StudentDTO> findAllStudents() {

        if (studentRepository.findAll().isEmpty())
            throw new NotFoundException("There is not any students");

        return studentRepository.findAll()
                .stream()
                .map(studentEntity -> StudentMapper.INSTANCE.toDto(studentEntity))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO update(Long anyLong, StudentDTO studentDTO) {
        return StudentMapper.INSTANCE.toDto(studentRepository.save(StudentMapper.INSTANCE.toEntity(studentDTO)));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
