import java.util.ArrayList;
import java.util.List;

public class KlonowanieListy {

    // ==========================================================
    // GOTOWIEC 3: GŁĘBOKA KOPIA LISTY OBIEKTÓW
    // Wymaga, żeby w klasie Rekord był zrobiony "Konstruktor Kopiujący" 
    // (który wrzucałem Ci w poprzednich wiadomościach!)
    // ==========================================================
    public static List<Rekord> sklonujWszystko(List<Rekord> oryginal) {

        List<Rekord> bezpiecznaKopia = new ArrayList<>();

        for (Rekord r : oryginal) {
            // Używamy "new", żeby wymusić stworzenie osobnego bytu w pamięci
            bezpiecznaKopia.add(new Rekord(r));
        }

        return bezpiecznaKopia;
    }
}