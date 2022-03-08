package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.RolesDto;
import it.unikey.acadesteam.DAL.entity.RolesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    RolesDto fromRolesEntityToRolesDto(RolesEntity entity);
    RolesEntity fromRolesDtoToRolesEntity(RolesDto dto);

}
