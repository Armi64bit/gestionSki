package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;

@RestController
@RequestMapping("/skieur")
@AllArgsConstructor
public class SkieurController  {
    private SkieurServiceImp sk;
    @PostMapping("/add")
    public Skieur addFoyer(@RequestBody Skieur f) {
        return  sk.add(f);
    }
    @PutMapping("/update")
    public Skieur updateFoyer(@RequestBody Skieur f) {
        return  sk.update(f);
    }

    @GetMapping("/getall")
    public List<Skieur> findAllFoyer() {
        return  sk.findAll();
    }
    @GetMapping("/get/{idF}")
    public Skieur findById(@PathVariable long idF) {
        return  sk.findById(idF);
    }
    @DeleteMapping("/delete/{idF}")
    public void deleteFoyer(@PathVariable long idF) {
        sk.delete(idF);
    }
    @PostMapping("/{numSkieur}/inscriptions")
    public Inscription addInscriptionAndAssignToSkieur(@PathVariable Long numSkieur, @RequestBody Inscription inscription) {
        return sk.addInscriptionAndAssignToSkieur(inscription, numSkieur);
    }
}
