package ch.iw.edumago.service;

import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.persistency.entity.TeacherEntity;
import ch.iw.edumago.persistency.repository.TeacherRepository;
import ch.iw.edumago.service.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO create(TeacherDTO teacherDTO) {

        TeacherEntity savedTeacherEntity = teacherRepository.save(TeacherMapper.INSTANCE.teacherDTO2teacherEntity(teacherDTO));

        TeacherDTO savedTeacherDTO = TeacherMapper.INSTANCE.teacherEntity2teacherDTO(savedTeacherEntity);

        return savedTeacherDTO;
    }
}
