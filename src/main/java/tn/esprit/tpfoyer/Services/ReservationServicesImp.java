package tn.esprit.tpfoyer.Services;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Reservation;
import tn.esprit.tpfoyer.Repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServicesImp implements IReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> afficherListeReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation afficherReservationSelonID(String idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}