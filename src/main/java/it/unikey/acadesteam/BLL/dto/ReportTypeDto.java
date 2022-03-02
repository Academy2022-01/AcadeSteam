package it.unikey.acadesteam.BLL.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ReportTypeDto {
    private Integer id;
    private String description;
    private Set<ReportDto> reports;
}
