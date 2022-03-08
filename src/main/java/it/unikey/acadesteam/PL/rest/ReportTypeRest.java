package it.unikey.acadesteam.PL.rest;

import it.unikey.acadesteam.BLL.dto.ReportDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ReportTypeRest {
    private Integer id;
    private String description;
    //private Set<ReportRest> reports;
}
