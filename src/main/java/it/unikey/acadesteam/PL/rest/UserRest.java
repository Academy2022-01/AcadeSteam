package it.unikey.acadesteam.PL.rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class UserRest {
    private Integer id;
    private String username;
    private String password;
    boolean isActive;
    private String email;
}
