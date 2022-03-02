package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.ReportTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportTypeRepository extends JpaRepository<ReportTypeEntity, Integer> {
}
