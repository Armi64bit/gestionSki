package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.Abo;
import tn.esprit.gestionski.services.IAbo;

import java.util.Set;

@RestController
@RequestMapping("/abo")
@AllArgsConstructor
public class AboController {
    IAbo ab;
    @GetMapping("/getbytorder/{type}")
    public Set<Abonnement> findById(@PathVariable TypeAbonnement type) {
        return ab.getSubscriptionByType(type);
    }

}
