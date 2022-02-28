package it.unikey.acadesteam.DAL.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class ReportEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;

}
