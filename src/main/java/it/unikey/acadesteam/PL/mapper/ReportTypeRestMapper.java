package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.BLL.dto.ReportDto;
import it.unikey.acadesteam.BLL.dto.ReportTypeDto;
import it.unikey.acadesteam.PL.rest.ReportRest;
import it.unikey.acadesteam.PL.rest.ReportTypeRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportTypeRestMapper {
    ReportTypeRest fromDtoToRest(ReportTypeDto dto);
    ReportTypeDto fromRestToDto(ReportTypeRest rest);
}
