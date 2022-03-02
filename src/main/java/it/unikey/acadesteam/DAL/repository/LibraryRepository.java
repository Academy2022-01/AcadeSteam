package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {
}
