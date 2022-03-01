package it.unikey.acadesteam.DAL.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "REPORT")
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
}
