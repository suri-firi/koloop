import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KuloodpornyCzytnik {

    // ==========================================================
    // GOTOWIEC 1: CZYTNIK, KTÓRY NIE UMIERA OD BŁĘDÓW W PLIKU
    // ==========================================================
    public static List<Rekord> wczytajBezpiecznie(String sciezka) {
        List<Rekord> lista = new ArrayList<>();
        try {
            Scanner skaner = new Scanner(new File(sciezka));

            while (skaner.hasNextLine()) {
                String linia = skaner.nextLine();
                if (linia.trim().isEmpty()) continue;

                String[] podzielone = linia.split(";");

                // MAGIA JEST TUTAJ: Try-Catch wewnątrz pętli!
                try {
                    lista.add(new Rekord(podzielone));
                } catch (Exception e) {
                    // Jak linijka jest zepsuta, to tylko o tym pisze, 
                    // ale NIE PRZERYWA działania programu! Pętla leci dalej.
                    System.out.println("⚠️ Zignorowano zepsutą linijkę: " + linia);
                }
            }
            skaner.close();
        } catch (Exception e) {
            System.out.println("Brak pliku na dysku!");
        }
        return lista;
    }
}