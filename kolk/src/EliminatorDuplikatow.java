import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EliminatorDuplikatow {

    // ==========================================================
    // GOTOWIEC 2: HASHSET (Pojemnik, który ignoruje kopie)
    // ==========================================================
    public static void wypiszUnikalneMiasta(List<Rekord> wszystkieDane) {

        // Set działa jak magiczny worek. Jak wrzucisz tam drugą "Warszawę", 
        // to worek po prostu ją wypluje w kosmos.
        Set<String> unikalneMiasta = new HashSet<>();

        for (Rekord r : wszystkieDane) {
            unikalneMiasta.add(r.getKolumna1()); // Wrzucamy nazwy miast
        }

        System.out.println("Znaleziono " + unikalneMiasta.size() + " UNIKALNYCH miast:");
        for (String miasto : unikalneMiasta) {
            System.out.println("- " + miasto);
        }
    }
}