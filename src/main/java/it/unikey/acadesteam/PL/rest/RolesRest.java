package it.unikey.acadesteam.PL.rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class RolesRest {
    private Integer id;
    private String description;
}
