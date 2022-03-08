package it.unikey.acadesteam.PL.rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class UserInfoRest {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private String gender;
}
