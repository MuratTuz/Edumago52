package ch.iw.edumago.service.mapper;

import ch.iw.edumago.model.RoleDTO;
import ch.iw.edumago.persistency.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANE = Mappers.getMapper(RoleMapper.class);

    RoleDTO toDTO(RoleEntity role);
    RoleEntity toEntity(RoleDTO roleDTO);
}
