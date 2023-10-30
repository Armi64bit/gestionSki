package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.services.InscriptionServiceImp;
import tn.esprit.gestionski.services.SkieurServiceImp;

@RestController
@RequestMapping("/inscri")
@AllArgsConstructor
public class InscriptionController {

    //private InscriptionServiceImp sk;
    @PostMapping("/add")
    public Inscription add(@RequestBody Skieur f) {
        return  null;
    }
}
