package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    @Query (" SELECT  e.numSeamiane FROM  Inscription e " +
            " JOIN Moniteur m" +
            " ON e.cours MEMBER m.cours"+
            " WHERE m.numMoniteur =: numMoniteur AND e.cours.support =: support")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("numMoniteur") Long numMoniteur, @Param("support")Support support);
}
