import java.util.List;
import java.util.stream.Collectors;

public class SzybkieFiltry {

    // ==========================================================
    // GOTOWIEC 2: STREAMY (Szybkie filtrowanie w jednej linijce)
    // ==========================================================
    public static List<Rekord> tylkoWielkieWartosci(List<Rekord> wszystkieDane) {

        return wszystkieDane.stream()
                // .filter działa jak sito. Zostawia tylko te, co spełniają warunek!
                .filter(r -> r.getKolumna2() > 1000)

                // .collect pakuje to, co przeszło przez sito, z powrotem do nowej Listy
                .collect(Collectors.toList());
    }
    
    /* JAK TEGO UŻYĆ W MAINIE?
       List<Rekord> bogacze = staraLista.stream()
                                        .filter(r -> r.getKolumna2() > 1000)
                                        .collect(Collectors.toList());
    */
}