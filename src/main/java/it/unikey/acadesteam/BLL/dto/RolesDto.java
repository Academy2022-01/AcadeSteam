package it.unikey.acadesteam.BLL.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class RolesDto {

    private Integer id;
    private String description;

}
