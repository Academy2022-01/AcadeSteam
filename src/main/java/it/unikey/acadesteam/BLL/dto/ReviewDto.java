package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.GameEntity;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ReviewDto {
    private Integer id;
    private GameDto game;
    private UserInfoDto userInfo;
    private Integer voteNumber;
    private String description;
    private LocalDate reviewDate;
}
