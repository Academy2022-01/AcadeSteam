package it.unikey.acadesteam.BLL.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class UserDto {

private Integer id;
private String username;
private String password;
private String email;
}
