package ch.iw.edumago.service.impl;

import ch.iw.edumago.model.EnrollmentDTO;
import ch.iw.edumago.persistency.entity.EnrollmentEntity;
import ch.iw.edumago.persistency.entity.StudentEntity;
import ch.iw.edumago.persistency.repository.EnrollmentRepository;
import ch.iw.edumago.persistency.repository.StudentRepository;
import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.service.EnrollmentService;
import ch.iw.edumago.service.StudentService;
import ch.iw.edumago.service.mapper.EnrollmentMapper;
import ch.iw.edumago.service.mapper.StudentMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DefaultEnrollmentService implements EnrollmentService {

    @Autowired private EnrollmentRepository enrollmentRepository;

    @Override
    @Transactional
    public EnrollmentDTO create(EnrollmentDTO enrollmentDTO) {

        EnrollmentEntity enrollmentEntity = EnrollmentMapper.INSTANCE.toEntity(enrollmentDTO);
        enrollmentEntity = enrollmentRepository.save(enrollmentEntity);

        return EnrollmentMapper.INSTANCE.toDto(enrollmentEntity);
    }

    @Override
    public Long add(EnrollmentDTO enrollmentDTO) {
        EnrollmentEntity enrollmentEntity = EnrollmentMapper.INSTANCE.toEntity(enrollmentDTO);
        enrollmentEntity = enrollmentRepository.save(enrollmentEntity);

        return enrollmentEntity.getId();
    }
}
