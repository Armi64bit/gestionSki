package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class InscriptionServiceImp implements  IInscription{
  private InscriptionRepository  inscriptionRepository;
    private   SkieurRepository  skieurRepository;

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {

        Skieur sk=skieurRepository.findById(numSkieur).orElse(null) ;
        inscription.setSkieur(sk);

        return         inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription add(Inscription S) {
        return inscriptionRepository.save(S);
    }

    @Override
    public Inscription update(Inscription S) {
        return inscriptionRepository.save(S);
    }

    @Override
    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription findById(long idS) {
        return inscriptionRepository.findById(idS).orElse(null);
    }

    @Override
    public void delete(long idS) {
         inscriptionRepository.deleteById(idS);

    }
}
