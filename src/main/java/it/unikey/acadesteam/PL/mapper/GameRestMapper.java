package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.PL.rest.GameRest;
import it.unikey.acadesteam.BLL.dto.GameDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameRestMapper {

    GameDto fromGameRestToGameDto(GameRest rest);
    GameRest fromGameDtoToGameRest(GameDto dto);
}
