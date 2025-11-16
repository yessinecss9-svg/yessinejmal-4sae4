package tn.esprit.tpfoyer.Services;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Universite;
import tn.esprit.tpfoyer.Repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServicesImp implements IUniveristeServices {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Universite ajouterUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> afficherListeUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite afficherUniversiteSelonID(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public Universite modifierUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
}