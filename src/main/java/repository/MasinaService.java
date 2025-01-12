package org.example.lab9;

import com.example.masini.model.Masina;
import com.example.masini.repository.MasinaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MasinaService {
    private final MasinaRepository masinaRepository;

    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public Masina adaugaMasina(Masina masina) {
        return masinaRepository.save(masina);
    }

    public void stergeMasina(String numarInmatriculare) {
        masinaRepository.deleteById(numarInmatriculare);
    }

    public Masina cautaMasina(String numarInmatriculare) {
        return masinaRepository.findById(numarInmatriculare).orElse(null);
    }

    public List<Masina> toateMasinile() {
        return (List<Masina>) masinaRepository.findAll();
    }

    public int numarMasiniMarca(String marca) {
        return masinaRepository.countByMarca(marca);
    }

    public List<Masina> masiniSub100000Km() {
        return masinaRepository.findAllWithKilometersUnder100000();
    }

    public List<Masina> masiniNoi() {
        return masinaRepository.findAllYoungerThanFiveYears();
    }
}
