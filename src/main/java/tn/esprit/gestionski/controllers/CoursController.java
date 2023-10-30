package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.services.ICours;

@RestController
@RequestMapping("/cours")
@AllArgsConstructor
public class CoursController {
    private ICours ic;
    @PostMapping("/addndas/{numc}")

    public Inscription addInscriptionAndAsignSkieru(@RequestBody Inscription i, @PathVariable long numc) {
        return ic.addInscriptionAndAssignToCours(i, numc);
    }
}
