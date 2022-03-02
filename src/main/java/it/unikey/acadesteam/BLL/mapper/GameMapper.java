package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.GameDto;
import it.unikey.acadesteam.DAL.entity.GameEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")

public interface GameMapper {
    GameDto fromGameEntityToGameDto(GameEntity entity);
    GameEntity fromGameDtoToGameEntity(GameDto dto);
}
