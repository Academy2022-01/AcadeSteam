package it.unikey.acadesteam.BLL.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LibraryDTO {
    private UUID id;
    private UUID gamesId;
    private UUID usersInfoId;
}
