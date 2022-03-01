package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.BLL.dto.UserDTO;
import it.unikey.acadesteam.PL.rest.UserRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRestMapper {
    UserRest fromUserDTOToUserRest(UserDTO dto);
    UserDTO fromUserRestToUserDTO(UserRest rest);
}
