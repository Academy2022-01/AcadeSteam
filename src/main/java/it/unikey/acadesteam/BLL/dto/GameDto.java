package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.GameStateEntity;
import lombok.Data;

@Data

public class GameDto {
    private Integer id;
    private String gameTitle;
    private String gamePath;
    private GameStateEntity gameState;
    private UserInfoDto developer;

}
