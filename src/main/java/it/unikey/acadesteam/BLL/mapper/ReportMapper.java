package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.ReportDto;
import it.unikey.acadesteam.BLL.dto.ReportTypeDto;
import it.unikey.acadesteam.DAL.entity.ReportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportDto fromEntityToDto(ReportEntity entity);
    ReportEntity fromDtoToEntity(ReportDto dto);
}
