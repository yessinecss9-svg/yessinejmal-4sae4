package tn.esprit.tpfoyer.Services;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Chambre;
import tn.esprit.tpfoyer.Repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServicesImp implements IChambreServices {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Chambre ajouterChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> afficherListeChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre afficherChambreSelonID(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public Chambre modifierChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void supprimerChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}