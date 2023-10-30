package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;

public interface ICours {
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, Long numCours) ;

}
