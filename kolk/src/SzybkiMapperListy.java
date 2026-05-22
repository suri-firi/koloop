import java.util.List;
import java.util.stream.Collectors;

public class SzybkiMapperListy {

    // ==========================================================
    // GOTOWIEC 2: STREAM MAP (Wyciąganie jednego konkretnego pola z listy)
    // ==========================================================
    public static List<String> wyciagnijSameNazwy(List<Rekord> wszystkieDane) {

        return wszystkieDane.stream()
                // .map() działa jak wyciskarka do soku. 
                // Wrzucasz całego "Rekorda", a wyciskasz z niego tylko jeden element (np. nazwę)
                .map(r -> r.getKolumna1())

                // I pakujemy ten "sok" z powrotem do nowej listy List<String>
                .collect(Collectors.toList());
    }

    /* JAK TEGO UŻYĆ W MAINIE?
       List<String> sameMiasta = SzybkiMapperListy.wyciagnijSameNazwy(wczytaneDane);
       System.out.println("Pierwsze miasto na liscie to: " + sameMiasta.get(0));
    */
}