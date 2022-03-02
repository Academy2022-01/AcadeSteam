package it.unikey.acadesteam.PL.rest;

import it.unikey.acadesteam.DAL.entity.GameEntity;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LibraryRest {

    private Integer id;
    private GameEntity game;
    private UserInfoEntity userInfo;
}
