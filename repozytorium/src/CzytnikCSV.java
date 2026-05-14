import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CzytnikCSV {
    public static List<Rekord> wczytaj(String sciezka, String separator, boolean pominNaglowek) {
        List<Rekord> lista = new ArrayList<>();
        try {
            Scanner skaner = new Scanner(new File(sciezka));

            // Jeśli pierwsza linia to napisy typu "Imię;Waga", to ją omijamy
            if (pominNaglowek && skaner.hasNextLine()) {
                skaner.nextLine();
            }

            while (skaner.hasNextLine()) {
                String linia = skaner.nextLine();
                if (linia.trim().isEmpty()) continue; // Omija puste linie

                String[] podzielone = linia.split(separator);
                lista.add(new Rekord(podzielone));
            }
            skaner.close();
        } catch (Exception e) {
            System.out.println("Błąd: Nie znaleziono pliku " + sciezka);
        }
        return lista;
    }
}