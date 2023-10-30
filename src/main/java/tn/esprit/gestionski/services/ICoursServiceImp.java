package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
@Service
@AllArgsConstructor
public class ICoursServiceImp implements ICours{
    CoursRepository cr;
    InscriptionRepository ir;
    @Override
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, Long numCours) {
        Cours crf=cr.findById(numCours).orElse(null);
        inscription.setCours( crf  );
        return ir.save(inscription) ;
    }
}
