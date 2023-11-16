package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.services.IMoniteur;
import tn.esprit.gestionski.services.IMoniteurImp;

@RestController
@AllArgsConstructor
@RequestMapping("/moni")

public class MoniteurController {
IMoniteurImp iMoniteur;
@PostMapping("/admac/{numc}")
public Moniteur addmandasc(Moniteur m,@PathVariable Long numc){
    return  iMoniteur.addMoniteurAndAssignToCours(m,numc);
}
}
