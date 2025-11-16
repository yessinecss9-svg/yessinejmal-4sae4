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
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;
    String name;
    long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    Set<Bloc> blocs;

    public long getIdFoyer() {
        return idFoyer;
    }

    public void setIdFoyer(long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Set<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(Set<Bloc> blocs) {
        this.blocs = blocs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCapaciteFoyer() {
        return capaciteFoyer;
    }

    public void setCapaciteFoyer(long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }
}
