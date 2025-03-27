package cz.veletova.pojisteni.service;

import cz.veletova.pojisteni.models.Pojistenec;
import cz.veletova.pojisteni.repository.PojistenecRepository;
import java.util.List;

public class PojistenecService {
    private PojistenecRepository repository = new PojistenecRepository();

    public List<Pojistenec> getAllPojistenci() {
        return repository.getAll();
    }

    public void pridatPojistence(Pojistenec pojistenec) {
        repository.add(pojistenec);
    }
    public void deletePojistenec(String email) {
        repository.deleteByEmail(email);
    }
    public void updatePojistenec(Pojistenec p) {
        repository.updatePojistenec(p);
    }

}
