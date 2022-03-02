package it.unikey.acadesteam.PL.rest;

import it.unikey.acadesteam.DAL.entity.LibraryEntity;
import it.unikey.acadesteam.DAL.entity.ReportEntity;
import it.unikey.acadesteam.DAL.entity.UserEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

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
