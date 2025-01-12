package repository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/masini")
public class MasinaController {
    private final MasinaService masinaService;

    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }

    @PostMapping
    public Masina adaugaMasina(@RequestBody Masina masina) {
        return masinaService.adaugaMasina(masina);
    }

    @DeleteMapping("/{numarInmatriculare}")
    public void stergeMasina(@PathVariable String numarInmatriculare) {
        masinaService.stergeMasina(numarInmatriculare);
    }

    @GetMapping("/{numarInmatriculare}")
    public Masina cautaMasina(@PathVariable String numarInmatriculare) {
        return masinaService.cautaMasina(numarInmatriculare);
    }

    @GetMapping
    public List<Masina> afiseazaToateMasinile() {
        return masinaService.afiseazaToateMasinile();
    }

    @GetMapping("/marca/{marca}")
    public int numaraMasiniCuMarca(@PathVariable String marca) {
        return (int) masinaService.numaraMasiniCuMarca(marca);
    }

    @GetMapping("/sub100k")
    public long numaraMasiniSubKilometri(@RequestParam int kilometri) {
        return masinaService.numaraMasiniSubKilometri(kilometri);
    }


    @GetMapping("/noi")
    public List<Masina> afiseazaMasiniMaiNoiDeAni(@RequestParam int ani) {
        return masinaService.afiseazaMasiniMaiNoiDeAni(ani);
    }

}
