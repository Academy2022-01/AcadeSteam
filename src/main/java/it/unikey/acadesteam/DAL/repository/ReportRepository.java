package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {
}
