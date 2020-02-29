package ch.iw.edumago.service.mapper;

import ch.iw.edumago.model.EnrollmentDTO;
import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.persistency.entity.EnrollmentEntity;
import ch.iw.edumago.persistency.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnrollmentMapper {

    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    EnrollmentDTO toDto(EnrollmentEntity enrollmentEntity);
    EnrollmentEntity toEntity(EnrollmentDTO enrollmentDTO);
}
