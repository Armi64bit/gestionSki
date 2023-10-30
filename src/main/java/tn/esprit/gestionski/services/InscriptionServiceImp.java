package tn.esprit.gestionski.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

public class InscriptionServiceImp implements  IInscription{
  private InscriptionRepository  inscriptionRepository;
    private   SkieurRepository  skieurRepository;
    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow(() -> new IllegalArgumentException("Skieur not found"));
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }
}
