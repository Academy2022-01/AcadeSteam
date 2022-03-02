package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.GameStateEntity;
import lombok.Data;

import java.util.UUID;

@Data

public class GameDto {
    private Integer id;
    private String gameTitle;
    private String gamePath;
    private GameStateDto gameState;

}
