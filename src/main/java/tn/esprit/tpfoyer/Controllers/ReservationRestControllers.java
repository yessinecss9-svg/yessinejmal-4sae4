package tn.esprit.tpfoyer.Controllers;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entities.Reservation;
import tn.esprit.tpfoyer.Services.IReservationServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationRestControllers {

    @Autowired
    private IReservationServices reservationServices;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationServices.ajouterReservation(reservation);
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservations() {
        return reservationServices.afficherListeReservations();
    }

    @GetMapping("/getReservationByID/{idR}")
    public Reservation getReservationByID(@PathVariable("idR") String idReservation) {
        return reservationServices.afficherReservationSelonID(idReservation);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationServices.modifierReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{idR}")
    public void deleteReservation(@PathVariable("idR") String idReservation) {
        reservationServices.supprimerReservation(idReservation);
    }
}