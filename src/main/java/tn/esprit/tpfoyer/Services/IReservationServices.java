package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entities.Reservation;

import java.util.List;

public interface IReservationServices {
    Reservation ajouterReservation(Reservation reservation);
    List<Reservation> afficherListeReservations();
    Reservation afficherReservationSelonID(String idReservation);
    Reservation modifierReservation(Reservation reservation);
    void supprimerReservation(String idReservation);
}
