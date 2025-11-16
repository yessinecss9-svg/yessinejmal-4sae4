package tn.esprit.tpfoyer.Controllers;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Etudiant;
import tn.esprit.tpfoyer.Services.IEtudiantServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantRestControllers {

    @Autowired
    private IEtudiantServices etudiantServices;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServices.ajouterEtudiant(etudiant);
    }

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantServices.afficherListeEtudiant();
    }

    @GetMapping("/getEtudiantByID/{idEt}")
    public Etudiant getEtudiantByID(@PathVariable("idEt") long idEtudiant) {
        return etudiantServices.afficherEtudiantSelonID(idEtudiant);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServices.modifierEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEt}")
    public void deleteEtudiant(@PathVariable("idEt") long idEtudiant) {
        etudiantServices.supprimerEtudiant(idEtudiant);
    }
}