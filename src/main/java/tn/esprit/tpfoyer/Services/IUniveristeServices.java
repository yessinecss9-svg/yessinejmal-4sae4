package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Universite;

import java.util.List;

public interface IUniveristeServices {
    Universite ajouterUniversite(Universite universite);
    List<Universite> afficherListeUniversite();
    Universite afficherUniversiteSelonID(long idUniversite);
    Universite modifierUniversite(Universite universite);
    void supprimerUniversite(long idUniversite);
}
