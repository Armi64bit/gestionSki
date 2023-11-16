package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class IMoniteurImp implements IMoniteur{
    MoniteurRepository mr;
    CoursRepository cr;
    @Override
    public Moniteur addMoniteurAndAssignToCours(Moniteur m, Long numc) {
        Cours C=cr.findById(numc).orElse(null);
        m.getCours().add(C);
        //List<Cours> coursSet= new ArrayList<>();
        //coursSet.add(C);
        //m.setCours(coursSet);
         return mr.save(m);
    }
}
