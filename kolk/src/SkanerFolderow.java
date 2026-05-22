import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SkanerFolderow {

    // ==========================================================
    // GOTOWIEC 1: WCZYTYWANIE WSZYSTKICH PLIKÓW Z KATALOGU
    // ==========================================================
    public static List<String> znajdzWszystkiePliki(String nazwaFolderu) {
        List<String> sciezkiDoPlikow = new ArrayList<>();
        File folder = new File(nazwaFolderu);

        // Sprawdzamy, czy to w ogóle istnieje i czy jest folderem
        if (folder.exists() && folder.isDirectory()) {

            // Pobieramy wszystko co leży w tym folderze
            File[] plikiWŚrodku = folder.listFiles();

            if (plikiWŚrodku != null) {
                for (File plik : plikiWŚrodku) {
                    // Omijamy podfoldery, bierzemy tylko zwykłe pliki (np. kończące się na .csv)
                    if (plik.isFile() && plik.getName().endsWith(".csv")) {
                        sciezkiDoPlikow.add(plik.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("🚨 Błąd: Nie ma takiego folderu!");
        }

        return sciezkiDoPlikow;
    }
    
    /* JAK TEGO UŻYĆ W MAINIE?
       List<String> pliki = SkanerFolderow.znajdzWszystkiePliki("moje_dane");
       for (String sciezka : pliki) {
           // Tutaj używasz swojego CzytnikCSV dla każdej ścieżki po kolei!
           List<Rekord> porcja = CzytnikCSV.wczytaj(sciezka, ";", true);
           wielkaLista.addAll(porcja); // addAll dokleja jedną listę do drugiej!
       }
    */
}