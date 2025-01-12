package repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MasinaRepository extends CrudRepository<Masina, String> {

    @Query("SELECT * FROM masini")
    List<Masina> findAll();

    @Modifying
    @Query("DELETE FROM masini WHERE numar_inmatriculare = :numarInmatriculare")
    void deleteByNumarInmatriculare(String numarInmatriculare);

    @Query("SELECT * FROM masini WHERE numar_inmatriculare = :numarInmatriculare")
    Masina findByNumarInmatriculare(String numarInmatriculare);

    @Query("SELECT COUNT(*) FROM masini WHERE marca = :marca")
    long countByMarca(String marca);

    @Query("SELECT COUNT(*) FROM masini WHERE numar_kilometri < :kilometri")
    long countByKilometriLessThan(int kilometri);

    @Query("SELECT * FROM masini WHERE an_fabricatie > :an")
    List<Masina> findByAnFabricatieGreaterThan(int an);

    @Modifying
    @Query("INSERT INTO masini (numar_inmatriculare, marca, an_fabricatie, culoare, numar_kilometri) " +
            "VALUES (:numarInmatriculare, :marca, :anFabricatie, :culoare, :numarKilometri)")
    void adaugaMasina(String numarInmatriculare, String marca, int anFabricatie, String culoare, int numarKilometri);

}
