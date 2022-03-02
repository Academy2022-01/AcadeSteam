package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.GameStateDto;
import it.unikey.acadesteam.DAL.entity.GameStateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameStateMapper {
    GameStateDto fromGameStateEntityToGameStateDto(GameStateEntity entity);
    GameStateEntity fromGameStateDtoToGameStateEntity(GameStateDto dto);
}
