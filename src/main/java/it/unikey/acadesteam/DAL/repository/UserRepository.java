package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByUUDD (UUID uuid);
}
