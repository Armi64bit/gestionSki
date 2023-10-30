package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;

public interface IInscription {
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur);
}
