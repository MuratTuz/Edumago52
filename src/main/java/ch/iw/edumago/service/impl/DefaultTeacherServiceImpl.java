package ch.iw.edumago.service.impl;

import ch.iw.edumago.exceptions.NotFoundException;
import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.persistency.entity.TeacherEntity;
import ch.iw.edumago.persistency.repository.TeacherRepository;
import ch.iw.edumago.service.TeacherService;
import ch.iw.edumago.service.mapper.TeacherMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultTeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public DefaultTeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO create(TeacherDTO teacherDTO) {

        TeacherEntity savedTeacherEntity = teacherRepository.save(TeacherMapper.INSTANCE.toEntity(teacherDTO));

        TeacherDTO savedTeacherDTO = TeacherMapper.INSTANCE.toDTO(savedTeacherEntity);

        return savedTeacherDTO;
    }

    @Override
    public List<TeacherDTO> findAll() {
        if (teacherRepository.findAll().isEmpty())
            throw new NotFoundException("There is not any students");

        return teacherRepository.findAll()
                                .stream()
                                .map(entity -> TeacherMapper.INSTANCE.toDTO(entity))
                                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO findById(Long id) {

        return teacherRepository.findById(id).map(entity -> TeacherMapper.INSTANCE.toDTO(entity)).get();
    }

    @Override
    @Transactional
    public TeacherDTO update(Long id, TeacherDTO teacherDTO) {

        return TeacherMapper.INSTANCE.toDTO(teacherRepository.save(TeacherMapper.INSTANCE.toEntity(teacherDTO)));
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }
}
