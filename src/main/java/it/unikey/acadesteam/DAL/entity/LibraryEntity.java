package it.unikey.acadesteam.DAL.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name= "LIBRARY")
public class LibraryEntity {


    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;


<<<<<<< .merge_file_a07500
    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GameEntity> game;
=======
    @ManyToOne(fetch = FetchType.LAZY)
    private GameEntity game;
>>>>>>> .merge_file_a11260

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfoEntity userInfo;





}
