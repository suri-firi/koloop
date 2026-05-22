import java.util.List;
import java.util.Optional;

public class BezpiecznaWyszukiwarka {

    // ==========================================================
    // GOTOWIEC 2: OPTIONAL (Ochrona przed NullPointerException)
    // ==========================================================
    public static Optional<Rekord> znajdzPoNazwie(List<Rekord> lista, String szukanaNazwa) {

        for (Rekord r : lista) {
            if (r.getKolumna1().equals(szukanaNazwa)) {
                // ZNALEZIONO! Pakujemy do pudełka i oddajemy.
                return Optional.of(r);
            }
        }
        // NIE ZNALEZIONO! Oddajemy PUSTE pudełko, zamiast groźnego nulla.
        return Optional.empty();
    }
    
    /* JAK TEGO UŻYĆ W MAINIE?
       Optional<Rekord> wynik = BezpiecznaWyszukiwarka.znajdzPoNazwie(dane, "Warszawa");
       
       if (wynik.isPresent()) {
           System.out.println("Znalazłem: " + wynik.get().getKolumna1());
       } else {
           System.out.println("Nie ma takiego miasta w pliku!");
       }
    */
}