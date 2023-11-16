package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Abonnement;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
}
