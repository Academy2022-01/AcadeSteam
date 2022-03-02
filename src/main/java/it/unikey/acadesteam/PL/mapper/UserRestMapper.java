package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.BLL.dto.UserDto;
import it.unikey.acadesteam.PL.rest.UserRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRestMapper {
    UserRest fromUserDTOToUserRest(UserDto dto);
    UserDto fromUserRestToUserDTO(UserRest rest);
}
