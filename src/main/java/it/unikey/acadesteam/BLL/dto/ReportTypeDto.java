package it.unikey.acadesteam.BLL.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class ReportTypeDto {
    private UUID id;
    private String description;
    private Set<ReportDto> reports;
}
