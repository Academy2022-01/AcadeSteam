package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.GameEntity;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;

import java.time.LocalDate;

public class ReviewDto {
    private Integer id;
    private GameEntity game;
    private UserInfoEntity userInfo;
    private Integer voteNumber;
    private String description;
    private LocalDate reviewDate;
}
