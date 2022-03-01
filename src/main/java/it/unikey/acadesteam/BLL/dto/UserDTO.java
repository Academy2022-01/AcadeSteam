package it.unikey.acadesteam.BLL.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
private UUID id;
private String username;
private String password;
private String email;
}
