package ch.iw.edumago.service.mapper;

import ch.iw.edumago.model.TeacherDTO;
import ch.iw.edumago.persistency.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherEntity teacherDTO2teacherEntity(TeacherDTO teacherDTO);

    TeacherDTO teacherEntity2teacherDTO(TeacherEntity teacherEntity);
}
