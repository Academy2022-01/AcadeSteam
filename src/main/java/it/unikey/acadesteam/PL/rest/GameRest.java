package it.unikey.acadesteam.PL.rest;

import it.unikey.acadesteam.BLL.dto.LibraryDto;
import it.unikey.acadesteam.BLL.dto.ReportDto;
import it.unikey.acadesteam.DAL.entity.GameStateEntity;

import java.util.Set;

public class GameRest {
    private Integer id;
    private String gameTitle;
    private String gamePath;
    private GameStateRest gameState;
    private Set<ReportRest> reports;
    //private Set<LibraryRest> library;
    //private UserInfoRest developer;
    //private Set<ReviewRest> reviews;
}
