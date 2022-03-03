package it.unikey.acadesteam.PL.rest;

import it.unikey.acadesteam.BLL.dto.GameDto;
import it.unikey.acadesteam.BLL.dto.ReportTypeDto;
import it.unikey.acadesteam.BLL.dto.UserInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ReportRest {
    private Integer id;
    private LocalDate date;
    private String description;
    private ReportTypeRest reportType;
    private GameRest game;
    private UserInfoRest userInfo;
}