package it.unikey.acadesteam.DAL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;


public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
}
