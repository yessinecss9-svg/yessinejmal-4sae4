package tn.esprit.tpfoyer.Services;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entities.Bloc;
import tn.esprit.tpfoyer.Repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServicesImp implements IBlocServices {

    @Autowired
    private BlocRepository blocRepository;

    @Override
    public Bloc ajouterBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> afficherListeBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc afficherBlocSelonID(long idBloc) {
        return blocRepository.getReferenceById(idBloc);
    }

    @Override
    public Bloc modifierBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void supprimerBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}
