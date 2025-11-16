package tn.esprit.tpfoyer.Services;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Etudiant;
import tn.esprit.tpfoyer.Repositories.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServicesImp implements IEtudiantServices {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> afficherListeEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant afficherEtudiantSelonID(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public Etudiant modifierEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}