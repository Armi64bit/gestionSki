package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor

public class Abo implements IAbo{
    AbonnementRepository ar;
    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return ar.getSubscriptionByType(type);
    }

    @Override
    public Set<Abonnement> retrieveSubscriptionsByDates(Date date1, Date date2) {
        return ar.findAbonnementByDateDebutBetween(date1,date2);
    }
}
