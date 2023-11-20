package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Set;

public interface IAbo {
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
}
