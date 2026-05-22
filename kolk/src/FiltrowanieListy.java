import java.util.ArrayList;
import java.util.List;

public class FiltrowanieListy {

    // ==========================================================
    // GOTOWIEC: ZWRACA NOWĄ LISTĘ TYLKO Z WYBRANYMI ELEMENTAMI
    // Jak uzyć w Main: 
    // List<Rekord> przefiltrowane = FiltrowanieListy.zostawTylkoDuze(staraLista);
    // ==========================================================
    public static List<Rekord> zostawTylkoDuze(List<Rekord> staraLista) {

        // Tworzymy pustą listę na nasze wybrane elementy
        List<Rekord> nowaLista = new ArrayList<>();

        for (Rekord r : staraLista) {

            // TUTAJ ZMIENIASZ WARUNEK!
            // Np. r.getKolumna2() > 1000 (Zostawia tylko te większe niż 1000)
            // Albo r.getKolumna1().equals("Polska") (Zostawia tylko Polskę)
            if (r.getKolumna2() > 1000) {
                // Jeśli spełnia warunek, wrzucamy do nowego worka
                nowaLista.add(r);
            }
        }

        return nowaLista; // Oddajemy przefiltrowany worek
    }
}