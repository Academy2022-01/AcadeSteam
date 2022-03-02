package it.unikey.acadesteam.PL.mapper;


import it.unikey.acadesteam.BLL.dto.LibraryDto;
import it.unikey.acadesteam.BLL.dto.UserInfoDto;
import it.unikey.acadesteam.PL.rest.LibraryRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryRestMapper {

    LibraryRest fromDtoToRest(LibraryDto dto);
    LibraryDto fromRestToDto(LibraryRest rest);


}
