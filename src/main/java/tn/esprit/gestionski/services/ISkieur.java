package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface ISkieur {
    public Skieur add(Skieur S);
    public Skieur update(Skieur S);
    public List<Skieur> findAll();
    public Skieur findById(long idS);
    public void delete(long idS);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);}
