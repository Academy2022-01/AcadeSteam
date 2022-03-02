package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "GAMES")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String gameTitle;

    @Column(nullable = false, unique = true)
    private String gamePath;

    @ManyToOne
    private GameStateEntity gameState;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LibraryEntity> library;

}
