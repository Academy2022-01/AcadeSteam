package it.unikey.acadesteam.BLL.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ReportDto {
    private Integer id;
    private LocalDate date;
    private String description;
    private ReportTypeDto reportType;
    private GameDto game;
    private UserInfoDto userInfo;
}
