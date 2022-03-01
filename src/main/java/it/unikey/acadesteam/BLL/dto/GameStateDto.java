package it.unikey.acadesteam.BLL.dto;

import lombok.Data;

import java.util.UUID;

@Data

public class GameStateDto {
    private UUID id;
    private String gameStateDescription;
}
