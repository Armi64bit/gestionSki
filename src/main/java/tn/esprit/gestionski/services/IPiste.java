package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Piste;

import java.util.List;

public interface IPiste {
    //public Piste addInscriptionAndAssignToSkieur(Piste inscription, Long numSkieur);
    public Piste add(Piste S);
    public Piste update(Piste S);
    public List<Piste> findAll();
    public Piste findById(long idS);
    public void delete(long idS);
}
