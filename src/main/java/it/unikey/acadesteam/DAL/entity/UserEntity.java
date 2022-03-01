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
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfo_id", referencedColumnName = "id")
    private UserInfoEntity userInfo;*/

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) return false;
        UserEntity that = (UserEntity) obj;
        return id != null && Objects.equals(id, that.id);
    }
}
