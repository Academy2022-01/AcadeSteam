package it.unikey.acadesteam.DAL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibraryRepository extends JpaRepository<LibraryEntity, UUID> {
}
