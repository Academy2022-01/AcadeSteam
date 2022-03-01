package it.unikey.acadesteam.BLL.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ReportDto {
    private UUID id;
    private LocalDate date;
    private String description;
    private ReportTypeDto reportType;
    private GameDto game;
    private UserInfoDto userInfo;
}
