package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.UserEntity;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserEntity findByEmail(String email);



}
