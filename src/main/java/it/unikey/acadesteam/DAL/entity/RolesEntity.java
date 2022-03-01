package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
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
    private Set<UserEntity> userEntitySet;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) return false;
        RolesEntity that = (RolesEntity) obj;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
