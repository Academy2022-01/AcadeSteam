package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.ReportTypeDto;
import it.unikey.acadesteam.DAL.entity.ReportTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportTypeMapper {
    ReportTypeDto fromEntityToDto(ReportTypeEntity entity);
    ReportTypeEntity fromDtoToEntity(ReportTypeDto dto);
}
