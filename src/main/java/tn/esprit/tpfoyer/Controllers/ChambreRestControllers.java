package tn.esprit.tpfoyer.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Bloc;
import tn.esprit.tpfoyer.Entities.Chambre;
import tn.esprit.tpfoyer.Services.IChambreServices;

import java.util.List;


@RestController
@RequestMapping("/chambre")
public class ChambreRestControllers {

    @Autowired
    private IChambreServices chambreServices;

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreServices.ajouterChambre(chambre);
    }

    @GetMapping("/getAllChambres")
    public List<Chambre> getAllChambres() {
        return chambreServices.afficherListeChambres();
    }

    @GetMapping("/getChambreByID/{idCh}")
    public Chambre getChambreByID(@PathVariable("idCh") long idChambre) {
        return chambreServices.afficherChambreSelonID(idChambre);
    }

    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreServices.modifierChambre(chambre);
    }

    @DeleteMapping("/deleteChambre/{idCh}")
    public void deleteChambre(@PathVariable("idCh") long idChambre) {
        chambreServices.supprimerChambre(idChambre);
    }
}