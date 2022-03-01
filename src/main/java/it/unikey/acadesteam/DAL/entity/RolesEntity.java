package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ROLES")
public class RolesEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "ROLES_USER")
    @GenericGenerator(name = "ROLES_USER", strategy = "uuid2")
    @Column(name = "id_roles", length = 16, unique= true, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String description;

    @OneToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id_user")
    private Set<UserEntity> userEntitySet;
}
