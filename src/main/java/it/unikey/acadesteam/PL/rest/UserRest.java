package it.unikey.acadesteam.PL.rest;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRest {
    private UUID id;
    private String username;
    private String password;
    boolean isActive;
    private String email;
}
