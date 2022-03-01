package it.unikey.acadesteam.DAL.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "REPORTS")
public class ReportEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;

    @Column(name = "DATE", nullable = false)
    private LocalDate reportDate;

    @Column(name = "DESCRIPTION", length = 500,  nullable = false)
    private String description;

    @ManyToOne
    private ReportTypeEntity reportType;

    @ManyToOne
    private GameEntity game;

    @ManyToOne
    private UserInfoEntity userInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReportEntity that = (ReportEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
