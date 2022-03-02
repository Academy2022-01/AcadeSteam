package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.RolesDto;
import it.unikey.acadesteam.BLL.dto.UserDto;
import it.unikey.acadesteam.DAL.entity.RolesEntity;
import it.unikey.acadesteam.DAL.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    RolesDto fromRolesEntityToRolesDto(RolesEntity entity);
    RolesEntity fromRolesDtotoRolesEntity(RolesDto dto);

}
