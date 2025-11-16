package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Chambre;

import java.util.List;

public interface IChambreServices {
    Chambre ajouterChambre(Chambre chambre);
    List<Chambre> afficherListeChambres();
    Chambre afficherChambreSelonID(long idChambre);
    Chambre modifierChambre(Chambre chambre);
    void supprimerChambre(long idChambre);
}
