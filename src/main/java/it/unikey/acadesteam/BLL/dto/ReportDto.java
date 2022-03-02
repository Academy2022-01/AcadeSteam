package it.unikey.acadesteam.BLL.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportDto {
    private Integer id;
    private LocalDate date;
    private String description;
    private ReportTypeDto reportType;
    private GameDto game;
    private UserInfoDto userInfo;
}
