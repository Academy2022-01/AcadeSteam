package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.BLL.dto.GameDto;
import it.unikey.acadesteam.BLL.dto.GameStateDto;
import it.unikey.acadesteam.PL.rest.GameRest;
import it.unikey.acadesteam.PL.rest.GameStateRest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameStateRestMapper {

    GameStateDto fromGameStateRestToGameDto(GameStateRest rest);
    GameStateRest fromGameStateDtoToGameRest(GameStateDto dto);
}
