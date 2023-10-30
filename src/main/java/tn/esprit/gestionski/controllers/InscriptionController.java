package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.services.IInscription;
import tn.esprit.gestionski.services.InscriptionServiceImp;

import java.util.List;

@RestController
@RequestMapping("/inscri")
@AllArgsConstructor
public class InscriptionController {
    private IInscription sk;

    @PostMapping("/add")
    public Inscription addFoyer(@RequestBody Inscription f) {
        return sk.add(f);
    }

    @PutMapping("/update")
    public Inscription updateFoyer(@RequestBody Inscription f) {
        return sk.update(f);
    }

    @GetMapping("/getall")
    public List<Inscription> findAllFoyer() {
        return sk.findAll();
    }

    @GetMapping("/get/{idF}")
    public Inscription findById(@PathVariable long idF) {
        return sk.findById(idF);
    }

    @DeleteMapping("/delete/{idF}")
    public void deleteFoyer(@PathVariable long idF) {
        sk.delete(idF);
    }

    @PostMapping("/addndas/{numsk}")

    public Inscription addInscriptionAndAsignSkieru(@RequestBody Inscription i, @PathVariable long numsk) {
        return sk.addInscriptionAndAssignToSkieur(i, numsk);
    }

}
