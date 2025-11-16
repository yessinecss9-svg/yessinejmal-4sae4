package tn.esprit.tpfoyer.Controllers;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Universite;
import tn.esprit.tpfoyer.Services.IUniveristeServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteRestControllers {

    @Autowired
    private IUniveristeServices universiteServices;

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteServices.ajouterUniversite(universite);
    }

    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites() {
        return universiteServices.afficherListeUniversite();
    }

    @GetMapping("/getUniversiteByID/{idU}")
    public Universite getUniversiteByID(@PathVariable("idU") long idUniversite) {
        return universiteServices.afficherUniversiteSelonID(idUniversite);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteServices.modifierUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{idU}")
    public void deleteUniversite(@PathVariable("idU") long idUniversite) {
        universiteServices.supprimerUniversite(idUniversite);
    }
}
