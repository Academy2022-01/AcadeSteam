package it.unikey.acadesteam.DAL.repository;

import it.unikey.acadesteam.DAL.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    /*QUERY GET FONDAMENTALI DI REVIEW:
        find by id
        find all by game
        find all by user_info

      QUERY GET PARTICOLARI DI REVIEW:
        find all by game and user_info
        find all by game and reviewdate after
        find all by game and reviewdate before
        find all by user_info and reviewdate after
        find all by user_info and reviewdate before
        find all by game and voteNumber

      QUERY RCEATE PARTICOLARI DI REVIEW:

      QUERY UPDATE PARTICOLARI DI REVIEW:

      QUERY DELETE PARTICOLARI DI REVIEW:

    * */
}
