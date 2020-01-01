package ch.iw.edumago.service.mapper;

import ch.iw.edumago.model.StudentDTO;
import ch.iw.edumago.persistency.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDto(StudentEntity studentEntity);
    StudentEntity toEntity(StudentDTO studentDTO);
}
