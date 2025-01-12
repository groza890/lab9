package repository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MasinaService {

    private final MasinaRepository masinaRepository;

    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public Masina adaugaMasina(Masina masina) {
        masinaRepository.save(masina);
        return masina;
    }

    public void stergeMasina(String numarInmatriculare) {
        masinaRepository.deleteByNumarInmatriculare(numarInmatriculare);
    }

    public Masina cautaMasina(String numarInmatriculare) {
        return masinaRepository.findByNumarInmatriculare(numarInmatriculare);
    }

    public List<Masina> afiseazaToateMasinile() {
        return masinaRepository.findAll();
    }

    public long numaraMasiniCuMarca(String marca) {
        return masinaRepository.countByMarca(marca);
    }

    public long numaraMasiniSubKilometri(int kilometri) {
        return masinaRepository.countByKilometriLessThan(kilometri);
    }

    public List<Masina> afiseazaMasiniMaiNoiDeAni(int ani) {
        int anulCurent = LocalDate.now().getYear();
        int limita = anulCurent - ani;
        return masinaRepository.findByAnFabricatieGreaterThan(limita);
    }
}
