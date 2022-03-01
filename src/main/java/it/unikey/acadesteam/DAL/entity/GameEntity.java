package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Game")
public class GameEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String gameTitle;

    @Column(nullable = false, unique = true)
    private String gamePath;

    @ManyToOne
    private GameStateEntity gameState;
/*
    @ManyToOne
    private UserInfoEntity developer;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReviewEntity> reviews;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReportEntity> reports;
    */
}
