import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperSortowanie {

    // ==========================================================
    // GOTOWIEC 2: SORTOWANIE WIELOKRYTERIOWE
    // ==========================================================
    public static void posortujPodwojnie(List<Rekord> lista) {

        // Tworzymy mega-komparator w jednej linijce
        Comparator<Rekord> komparator = Comparator
                // NAJPIERW sortuj po tym (np. po nazwie, rosnąco)
                .comparing(Rekord::getKolumna1)

                // A JAK SĄ RÓWNE, to sortuj po tym (np. po wartości, malejąco -> reversed)
                .thenComparing(Comparator.comparingDouble(Rekord::getKolumna2).reversed());

        // Odpalamy sortowanie na liście
        Collections.sort(lista, komparator);
    }
}