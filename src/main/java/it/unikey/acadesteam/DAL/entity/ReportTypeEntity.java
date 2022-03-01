package it.unikey.acadesteam.DAL.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "REPORT_TYPE")
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
    private Set<ReportEntity> reports;
}
