package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;
import java.util.Set;
@Slf4j
@Service
@AllArgsConstructor
public class SkieurServiceImp implements ISkieur {
    @Autowired
    private SkieurRepository sk;
    private InscriptionRepository inscriptionRepository;
    private PisteRepository pr;
    private CoursRepository cr;
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
    @Override

    public Skieur assignKieurToCours(Skieur Sk,Long NumC){
        Skieur skieur1 = sk.save(Sk);
        Cours cours = cr.findById(NumC).orElse(null);
        Set<Inscription> inscriptionList = skieur1.getInscripions();
        for (Inscription i:inscriptionList){
            i.setSkieur(skieur1);
            i.setCours(cours);
            inscriptionRepository.save(i);
        }
        return skieur1;
    }

    @Override
    public List<Skieur> retriveSkByTa(TypeAbonnement t) {
        return sk.findSkieurByAbonnement_TypeAbonnement(t);
    }
@Scheduled(fixedRate = 3000)
    public void fixedrate(){
log.info("lee ");
}
    @Scheduled(cron = "0 33 16 * * * ")
    public void cronfix(){
        log.info("crong ");
    }
}