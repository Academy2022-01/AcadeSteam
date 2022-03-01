package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
}
