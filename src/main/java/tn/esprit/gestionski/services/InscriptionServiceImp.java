package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class InscriptionServiceImp implements  IInscription{
  private InscriptionRepository  inscriptionRepository;
    private   SkieurRepository  skieurRepository;
    private CoursRepository ic;

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

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numMoniteur, Support support) {
        return inscriptionRepository.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
    }

    //ti5dimch
public Inscription addInscpriptionAndAssingToCoursAndSkieur(Inscription inscription, long numSkieur, long NumCours) {
    Cours cour = ic.findById(NumCours).orElse(null);
    Skieur skieur = skieurRepository.getById(numSkieur);

    if (cour.getTypeCours().equals(TypeCours.COLLECTIF_ENFANT) && cour.getInscripion().size() >= 6) {
        throw new IllegalArgumentException(" plus que 6 inscriptions pour cours.");
    } else if (cour.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE) && cour.getInscripion().size() >= 6) {
        throw new IllegalArgumentException(" que 6 inscriptions pour ce cours.");
    }
    LocalDate currentDate = LocalDate.now();
    LocalDate birthDate = skieur.getDateNaissance();
    int age = Period.between(birthDate, currentDate).getYears();

    if (cour.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE) && age < 18) {
        throw new IllegalArgumentException("Le skieur doit avoir au moins 18 ans pour s'inscrire à ce cours adulte.");
    }
    inscription.setCours(cour);
    inscription.setSkieur(skieur);

    return inscriptionRepository.save(inscription);
}
}




