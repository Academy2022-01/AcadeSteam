package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "USER")
public class UserEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "GUID_USER")
    @GenericGenerator(name = "GUID_USER", strategy = "uuid2")
    @Column(name = "id_user", length = 16, unique= true, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false)
    boolean isActive;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user", referencedColumnName = "id_roles")
    private RolesEntity roles;
}
