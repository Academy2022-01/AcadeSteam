package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.GameStateEntity;
import lombok.Data;

import java.util.Set;

@Data

public class GameDto {
    private Integer id;
    private String gameTitle;
    private String gamePath;
    private GameStateDto gameState;
    private Set<ReportDto> reports;
    private Set<LibraryDto> library;
    private UserInfoDto developer;
    //private Set<ReviewDto> reviews;

}
