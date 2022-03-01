package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Game_State")
public class GameStateEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    @Type(type="org.hibernate.type.StringNVarcharType")
    private String gameStateDescription;


    @OneToMany(mappedBy = "game_state", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GameEntity> games;

}
