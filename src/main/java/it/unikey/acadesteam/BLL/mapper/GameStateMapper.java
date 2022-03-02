package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.GameStateDto;
import it.unikey.acadesteam.BLL.dto.LibraryDto;
import it.unikey.acadesteam.DAL.entity.GameStateEntity;
import it.unikey.acadesteam.DAL.entity.LibraryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameStateMapper {
    GameStateDto fromGameStateEntityToGameStateDto(GameStateEntity entity);
    GameStateEntity fromGameStateDtoToGameStateEntity(GameStateDto dto);
    List<GameStateDto> fromGameStateEntitiesToDTOs(List<GameStateEntity> entities);
}
