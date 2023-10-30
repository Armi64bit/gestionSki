package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;

import java.util.List;

public interface IInscription {
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur);
    public Inscription add(Inscription S);
    public Inscription update(Inscription S);
    public List<Inscription> findAll();
    public Inscription findById(long idS);
    public void delete(long idS);
}
