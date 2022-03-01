package it.unikey.acadesteam.DAL.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "REPORT_TYPES")
public class ReportTypeEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;

    @Column(name = "DESCRIPTION", unique = true, nullable = false)
    private String description;

    @OneToMany(mappedBy = "reportType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<ReportEntity> reports;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReportTypeEntity that = (ReportTypeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
