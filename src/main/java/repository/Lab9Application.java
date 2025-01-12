package repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Lab9Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab9Application.class, args);
        MasinaService masinaService = context.getBean(MasinaService.class);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Meniu:");
            System.out.println("1. Adăugare mașină");
            System.out.println("2. Ștergere mașină după număr de înmatriculare");
            System.out.println("3. Căutare mașină după număr de înmatriculare");
            System.out.println("4. Afișare toate mașinile");
            System.out.println("5. Număr de mașini cu o marcă specificată");
            System.out.println("6. Număr de mașini cu sub 100.000 km");
            System.out.println("7. Afișare mașini mai noi de 5 ani");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți o opțiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumă newline

            switch (optiune) {
                case 1 -> {
                    System.out.print("Număr de înmatriculare: ");
                    String numarInmatriculare = scanner.nextLine();
                    System.out.print("Marcă: ");
                    String marca = scanner.nextLine();
                    System.out.print("An fabricație: ");
                    int anFabricatie = scanner.nextInt();
                    System.out.print("Culoare: ");
                    scanner.nextLine(); // Consumă newline
                    String culoare = scanner.nextLine();
                    System.out.print("Număr kilometri: ");
                    int kilometri = scanner.nextInt();

                    Masina masina = new Masina(numarInmatriculare, marca, anFabricatie, culoare, kilometri);
                    masinaService.adaugaMasina(masina);
                    System.out.println("Mașină adăugată cu succes!");
                }
                case 2 -> {
                    System.out.print("Introduceți numărul de înmatriculare: ");
                    String numarInmatriculare = scanner.nextLine();
                    masinaService.stergeMasina(numarInmatriculare);
                    System.out.println("Mașină ștearsă dacă a fost găsită!");
                }
                case 3 -> {
                    System.out.print("Introduceți numărul de înmatriculare: ");
                    String numarInmatriculare = scanner.nextLine();
                    Masina masina = masinaService.cautaMasina(numarInmatriculare);
                    if (masina != null) {
                        System.out.println("Mașină găsită: " + masina);
                    } else {
                        System.out.println("Mașină nu a fost găsită!");
                    }
                }
                case 4 -> masinaService.afiseazaToateMasinile()
                        .forEach(System.out::println);
                case 5 -> {
                    System.out.print("Introduceți marca: ");
                    String marca = scanner.nextLine();
                    long count = masinaService.numaraMasiniCuMarca(marca);
                    System.out.println("Număr de mașini cu marca " + marca + ": " + count);
                }
                case 6 -> {
                    long count = masinaService.numaraMasiniSubKilometri(100000);
                    System.out.println("Număr de mașini cu sub 100.000 km: " + count);
                }
                case 7 -> masinaService.afiseazaMasiniMaiNoiDeAni(5)
                        .forEach(System.out::println);
                case 0 -> running = false;
                default -> System.out.println("Opțiune invalidă! Încercați din nou.");
            }
        }

        System.out.println("Program încheiat. La revedere!");
    }
}
