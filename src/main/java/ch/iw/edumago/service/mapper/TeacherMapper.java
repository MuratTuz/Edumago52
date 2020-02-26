package ch.iw.edumago.service.mapper;

import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.persistency.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherEntity toEntity(TeacherDTO teacherDTO);

    TeacherDTO toDTO(TeacherEntity teacherEntity);
}
