import java.io.FileWriter;
import java.util.List;

public class ZapisywaczDoPliku {

    // ==========================================================
    // GOTOWIEC: ZAPIS DO ZWYKŁEGO PLIKU TXT LUB CSV
    // Jak uzyć w Main: 
    // ZapisywaczDoPliku.zapiszMojaListe(mojeDane, "wyniki.txt");
    // ==========================================================
    public static void zapiszMojaListe(List<Rekord> lista, String nazwaNowegoPliku) {
        try {
            // true dopisywałoby do pliku, my chcemy stworzyć nowy od zera, więc samo nazwaNowegoPliku
            FileWriter pisarz = new FileWriter(nazwaNowegoPliku);

            // Jeśli zadanie wymaga nagłówka na samej górze pliku, odkomentuj to:
            // pisarz.write("Nazwa\tWartosc\n"); 

            for (Rekord r : lista) {
                // TUTAJ ZMIENIASZ: Jak ma wyglądać jedna linijka w pliku!
                // "\t" to TABULATOR. "\n" to ENTER (nowa linia - MUSI BYĆ NA KOŃCU!)
                // Zmień r.getKolumna1() na swoje gettery.
                String linijka = r.getKolumna1() + "\t" + r.getKolumna2() + "\n";

                pisarz.write(linijka);
            }

            pisarz.close(); // BEZ TEGO PLIK BĘDZIE PUSTY!
            System.out.println("✅ Udało się zapisać dane do pliku: " + nazwaNowegoPliku);

        } catch (Exception e) {
            System.out.println("❌ Błąd podczas zapisywania do pliku!");
        }
    }
}