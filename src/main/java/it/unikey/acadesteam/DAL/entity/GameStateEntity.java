package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "GAME_STATES")
public class GameStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String gameStateDescription;

    @OneToMany(mappedBy = "gameState", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GameEntity> games;

}
