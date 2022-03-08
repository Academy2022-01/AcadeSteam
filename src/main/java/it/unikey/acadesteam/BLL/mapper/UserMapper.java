package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.UserDto;
import it.unikey.acadesteam.DAL.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromUserEntityToUserDto(UserEntity entity);
    UserEntity fromUserDtoToUserEntity(UserDto dto);
}

