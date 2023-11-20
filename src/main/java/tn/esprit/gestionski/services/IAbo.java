package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IAbo {
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    Set<Abonnement> retrieveSubscriptionsByDates(Date date1, Date endDate);
}
