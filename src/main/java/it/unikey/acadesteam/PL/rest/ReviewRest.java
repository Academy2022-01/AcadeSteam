package it.unikey.acadesteam.PL.rest;

import it.unikey.acadesteam.DAL.entity.GameEntity;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ReviewRest {
    private Integer id;
    private GameRest game;
    private UserInfoRest userInfo;
    private Integer voteNumber;
    private String description;
    private LocalDate reviewDate;
}
