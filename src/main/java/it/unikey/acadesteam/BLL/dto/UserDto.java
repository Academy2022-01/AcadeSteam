package it.unikey.acadesteam.BLL.dto;

import it.unikey.acadesteam.DAL.entity.RolesEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    boolean isActive;
    private String email;
    private UserInfoDto userInfo;
    private RolesDto role;
}
