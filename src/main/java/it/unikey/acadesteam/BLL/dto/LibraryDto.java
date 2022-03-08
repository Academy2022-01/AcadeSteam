package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.GameEntity;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class LibraryDto {
    private Integer id;
    private UserInfoDto userInfo;
    private GameDto games;
}