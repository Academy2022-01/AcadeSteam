package it.unikey.acadesteam.BLL.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Data
@RequiredArgsConstructor
public class UserInfoDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private String gender;
}
