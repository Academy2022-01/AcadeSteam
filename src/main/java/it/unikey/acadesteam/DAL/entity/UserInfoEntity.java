package it.unikey.acadesteam.DAL.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;


@Data
@Entity
@Table(name= "USERS_INFO")
public class UserInfoEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;

    @Column(name = "FRISTNAME", length = 150)
    private String fristName;

    @Column(name = "LASTNAME", length = 150)
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Column(name="NATIONALITY", nullable = false)
    private String nationality;

    @Column(name="GENDER",length = 150)
    private String gender;

    @OneToMany(mappedBy ="userInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReportEntity> reports;

}
