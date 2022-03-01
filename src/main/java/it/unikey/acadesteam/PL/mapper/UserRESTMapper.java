package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.BLL.dto.UserDTO;
import it.unikey.acadesteam.PL.rest.UserREST;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRESTMapper {
    UserREST fromUserDTOToUserRest(UserDTO dto);
    UserDTO fromUserRestToUserDTO(UserREST rest);
}
