package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.LibraryDTO;
import it.unikey.acadesteam.DAL.entity.LibraryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    LibraryDTO fromLibraryEntityToLibrarySto(LibraryEntity entity);
    LibraryEntity fromLibraryDtoToLibraryEntity(LibraryDTO dto);
}
