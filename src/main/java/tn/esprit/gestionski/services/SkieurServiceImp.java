package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SkieurServiceImp implements ISkieur {
    @Autowired
    private SkieurRepository sk;
    private InscriptionRepository inscriptionRepository;
    private PisteRepository pr;

    @Override
    public Skieur add(Skieur S) {
        return sk.save(S);
    }

    @Override
    public Skieur update(Skieur S) {
        return sk.save(S);
    }

    @Override
    public List<Skieur> findAll() {
        return sk.findAll();
    }

    @Override
    public Skieur findById(long idS) {
        return sk.findById(idS).orElse(null);
    }

    @Override
    public void delete(long idS) {
        sk.deleteById(idS);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
         Piste p = pr.findById(numPiste).orElse(null);
         Skieur s = sk.findById(numSkieur).orElse(null);
        s.getPistes().add(p);        return sk.save(s);
    }

    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        Skieur skieur = sk.findById(numSkieur).orElseThrow(() -> new IllegalArgumentException("Skieur not found"));
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }
}