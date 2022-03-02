package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.BLL.dto.ReportDto;
import it.unikey.acadesteam.BLL.dto.UserInfoDto;
import it.unikey.acadesteam.PL.rest.ReportRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoRestMapper {

    UserInfoRest fromDtoToRest(UserInfoDto dto);
    UserInfoDto fromRestToDto(UserInfoRest rest);

}
