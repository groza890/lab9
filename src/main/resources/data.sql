CREATE DATABASE IF NOT EXISTS spring_masini;
USE spring_masini;

CREATE TABLE IF NOT EXISTS masina (
                                      numar_inmatriculare VARCHAR(15) PRIMARY KEY,
    marca VARCHAR(50),
    an_fabricatie INT,
    culoare VARCHAR(30),
    kilometri INT
    );

INSERT INTO masina (numar_inmatriculare, marca, an_fabricatie, culoare, kilometri)
VALUES
    ('B-01-ABC', 'Dacia', 2020, 'Alb', 50000),
    ('CJ-23-XYZ', 'Toyota', 2019, 'Negru', 75000),
    ('TM-45-MNO', 'Volkswagen', 2022, 'Albastru', 30000),
    ('AG-99-PQR', 'BMW', 2018, 'Rosu', 90000),
    ('IS-88-GHI', 'Mercedes', 2021, 'Gri', 45000);
