package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserEntity findByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserEntity u WHERE u.id = :id")
    void deleteById(Integer id);

}
