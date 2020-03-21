package ch.iw.edumago.service.impl;

import ch.iw.edumago.exceptions.NotFoundException;
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
import java.util.stream.Collectors;

@Service
public class DefaultEnrollmentService implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public DefaultEnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    @Transactional
    public EnrollmentDTO create(EnrollmentDTO enrollmentDTO) {

        EnrollmentEntity enrollmentEntity = EnrollmentMapper.INSTANCE.toEntity(enrollmentDTO);
        EnrollmentEntity savedEnrollmentEntity = enrollmentRepository.save(enrollmentEntity);

        return EnrollmentMapper.INSTANCE.toDto(savedEnrollmentEntity);
    }

    @Override
    public List<EnrollmentDTO> findAll() {
        if (enrollmentRepository.findAll().isEmpty()) {
            throw new NotFoundException("There is no enrollment yet");
        }

        return enrollmentRepository.findAll()
                                    .stream()
                                    .map(entity -> EnrollmentMapper.INSTANCE.toDto(entity))
                                    .collect(Collectors.toList());

    }

    @Override
    public EnrollmentDTO findById(Long id) {
        return enrollmentRepository.findById(id).map(entity -> EnrollmentMapper.INSTANCE.toDto(entity)).get();
    }
}
