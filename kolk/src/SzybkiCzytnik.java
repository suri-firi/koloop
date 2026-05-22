import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SzybkiCzytnik {

    // ==========================================================
    // GOTOWIEC 3: MAGIA JAVA NIO (Czytanie całego pliku od razu)
    // ==========================================================
    public static List<Rekord> wczytajEkspresowo(String sciezka) {
        List<Rekord> gotoweObiekty = new ArrayList<>();

        try {
            // TA JEDNA LINIJKA CZYTA CAŁY PLIK DO LISTY TEKSTÓW!
            List<String> wszystkieLinieZPliku = Files.readAllLines(Path.of(sciezka));

            // Omijamy pierwszą linię (nagłówek) jeśli trzeba, więc pętla od i=1
            for (int i = 1; i < wszystkieLinieZPliku.size(); i++) {
                String linia = wszystkieLinieZPliku.get(i);

                if (!linia.trim().isEmpty()) {
                    String[] pociete = linia.split(";");
                    gotoweObiekty.add(new Rekord(pociete));
                }
            }
        } catch (Exception e) {
            System.out.println("Plik wyparował!");
        }

        return gotoweObiekty;
    }
}