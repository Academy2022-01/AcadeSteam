package it.unikey.acadesteam.BLL.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class ReportTypeDto {
    private Integer id;
    private String description;
    //private Set<ReportDto> reports;
}
