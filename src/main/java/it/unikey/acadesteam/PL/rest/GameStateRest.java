package it.unikey.acadesteam.PL.rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GameStateRest {
    private Integer id;
    private String gameStateDescription;

}
