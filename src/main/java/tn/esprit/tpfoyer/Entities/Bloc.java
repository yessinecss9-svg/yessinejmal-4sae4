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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    String name;
    String capaciteBloc;
    @ManyToOne
    Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    Set<Chambre> Chambres;

    public long getIdBloc() {
        return idBloc;
    }

    public void setIdBloc(long idBloc) {
        this.idBloc = idBloc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapaciteBloc() {
        return capaciteBloc;
    }

    public void setCapaciteBloc(String capaciteBloc) {
        this.capaciteBloc = capaciteBloc;
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public Set<Chambre> getChambres() {
        return Chambres;
    }

    public void setChambres(Set<Chambre> chambres) {
        Chambres = chambres;
    }
}
