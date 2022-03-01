package it.unikey.acadesteam.DAL.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "REVIEWS")
public class ReviewEntity {

    @Id
    @Type(type = "uuid-binary")
    @GeneratedValue(generator = "myGUID")
    @GenericGenerator(name = "myGUID", strategy = "uuid2")
    @Column(name = "ID", length = 16, unique= true, nullable = false)
    private UUID id;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private GameEntity game;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserInfoEntity usersInfo;

    @Column(name = "VOTE_NUMBER", nullable = false, length = 1)
    @Min(0)
    @Max(5)
    private Integer voteNumber;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "REVIEW_DATE", nullable = false)
    private LocalDate reviewDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReviewEntity that = (ReviewEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}