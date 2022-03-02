package it.unikey.acadesteam.BLL.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class UserInfoDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private String gender;
}
