package it.unikey.acadesteam.PL.rest;

import it.unikey.acadesteam.DAL.entity.GameEntity;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;

import java.time.LocalDate;

public class ReviewRest {
    private Integer id;
    private GameRest game;
    private UserInfoRest userInfo;
    private Integer voteNumber;
    private String description;
    private LocalDate reviewDate;
}
