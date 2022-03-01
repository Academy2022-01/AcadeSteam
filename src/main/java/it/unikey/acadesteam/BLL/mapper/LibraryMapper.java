package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.LibraryDto;
import it.unikey.acadesteam.DAL.entity.LibraryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    LibraryDto fromLibraryEntityToLibrarySto(LibraryEntity entity);
    LibraryEntity fromLibraryDtoToLibraryEntity(LibraryDto dto);
}
