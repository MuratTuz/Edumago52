package ch.iw.edumago.service.impl;

import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.persistency.entity.TeacherEntity;
import ch.iw.edumago.persistency.repository.TeacherRepository;
import ch.iw.edumago.service.TeacherService;
import ch.iw.edumago.service.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultTeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    public DefaultTeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO create(TeacherDTO teacherDTO) {

        TeacherEntity savedTeacherEntity = teacherRepository.save(TeacherMapper.INSTANCE.toEntity(teacherDTO));

        TeacherDTO savedTeacherDTO = TeacherMapper.INSTANCE.toDTO(savedTeacherEntity);

        return savedTeacherDTO;
    }
}
