package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.GameStateEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class GameDto {
    private Integer id;
    private String gameTitle;
    private String gamePath;
    private GameStateDto gameState;
    private UserInfoDto developer;
    //private Set<ReportDto> reports;
    //private Set<LibraryDto> library;
    //private Set<ReviewDto> reviews;

}
