package tn.esprit.tpfoyer.Controllers;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Foyer;
import tn.esprit.tpfoyer.Repositories.FoyerRepository;
import tn.esprit.tpfoyer.Services.IFoyerServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerRestControllers {

    @Autowired
    private IFoyerServices foyerServices;

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerServices.ajouterFoyer(foyer);
    }

    @GetMapping("/getAllFoyers")
    public List<Foyer> getAllFoyers() {
        return foyerServices.afficherListeFoyers();
    }

    @GetMapping("/getFoyerByID/{idF}")
    public Foyer getFoyerByID(@PathVariable("idF") long idFoyer) {
        return foyerServices.afficherFoyerSelonID(idFoyer);
    }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerServices.modifierFoyer(foyer);
    }

    @DeleteMapping("/deleteFoyer/{idF}")
    public void deleteFoyer(@PathVariable("idF") long idFoyer) {
        foyerServices.supprimerFoyer(idFoyer);
    }
}
