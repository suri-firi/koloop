import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrupowanieDanych {

    // ==========================================================
    // GOTOWIEC: LICZENIE ILE RAZY WYSTĘPUJE DANY ELEMENT
    // ==========================================================
    public static void policzWystapienia(List<Rekord> lista) {

        // Map<CoLiczymy, IleRazyWystapilo>
        // Przykład: Map<NazwaKraju, LiczbaOsob>
        Map<String, Integer> slownik = new HashMap<>();

        for (Rekord r : lista) {
            // TUTAJ ZMIENIASZ: Co chcesz pogrupować/policzyć?
            String klucz = r.getKolumna1();

            // Jeśli ten element jest już w słowniku:
            if (slownik.containsKey(klucz)) {
                int staraWartosc = slownik.get(klucz);
                slownik.put(klucz, staraWartosc + 1); // Zwiększamy o 1
            }
            // Jeśli widzimy ten element pierwszy raz:
            else {
                slownik.put(klucz, 1);
            }
        }

        // Wypisywanie wyników na ekran
        for (String nazwa : slownik.keySet()) {
            System.out.println(nazwa + " występuje: " + slownik.get(nazwa) + " razy.");
        }
    }
}