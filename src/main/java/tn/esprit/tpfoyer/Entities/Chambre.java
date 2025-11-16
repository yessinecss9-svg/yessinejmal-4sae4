package tn.esprit.tpfoyer.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChanmbre;
    long numchanmbre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
    @ManyToOne
    Bloc bloc;
    @OneToMany
    Set<Reservation> reservations;

    public long getIdChanmbre() {
        return idChanmbre;
    }

    public void setIdChanmbre(long idChanmbre) {
        this.idChanmbre = idChanmbre;
    }

    public long getNumchanmbre() {
        return numchanmbre;
    }

    public void setNumchanmbre(long numchanmbre) {
        this.numchanmbre = numchanmbre;
    }

    public TypeChambre getTypeC() {
        return typeC;
    }

    public void setTypeC(TypeChambre typeC) {
        this.typeC = typeC;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
