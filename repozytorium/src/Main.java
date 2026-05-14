import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- 1. ŁADOWANIE DANYCH ---
        // TUTAJ ZMIENIASZ: Nazwę pliku i separator ("," lub ";")
        String plik = "dane.csv";
        List<Rekord> lista = CzytnikCSV.wczytaj(plik, ";", true);

        if (lista.isEmpty()) {
            System.out.println("❌ Błąd: Lista jest pusta. Sprawdź czy plik .csv jest w dobrym folderze!");
            return;
        }
        System.out.println("✅ Wczytano " + lista.size() + " rekordów.");


        // --- 2. SORTOWANIE (Opcjonalne, ale daje +10 do profesjonalizmu) ---
        // Wykładowcy to kochają. Sortujemy od największej wartości do najmniejszej.
        Collections.sort(lista, new Comparator<Rekord>() {
            @Override
            public int compare(Rekord r1, Rekord r2) {
                // TUTAJ ZMIENIASZ: getKolumna2() na pole, po którym chcesz sortować
                return Double.compare(r2.getKolumna2(), r1.getKolumna2());
            }
        });


        // --- 3. STATYSTYKI (Szukanie Max/Min/Średniej) ---
        Rekord najlepszy = lista.get(0);
        double suma = 0;

        for (Rekord r : lista) {
            suma += r.getKolumna2();
            if (r.getKolumna2() > najlepszy.getKolumna2()) {
                najlepszy = r;
            }
        }
        double srednia = suma / lista.size();

        System.out.println("🏆 Najlepszy wynik: " + najlepszy.getKolumna1() + " (" + najlepszy.getKolumna2() + ")");
        System.out.println("📊 Średnia wartość: " + String.format("%.2f", srednia));


        // --- 4. GENEROWANIE GRAFIKI SVG ---
        // TUTAJ ZMIENIASZ: Rozmiar płótna
        GeneratorSVG svg = new GeneratorSVG(1000, 800);

        // Rysujemy tło (opcjonalne, ładniej wygląda)
        svg.dodaj("<rect width=\"100%\" height=\"100%\" fill=\"#f0f0f0\" />");

        for (int i = 0; i < lista.size(); i++) {
            Rekord r = lista.get(i);

            // LOGIKA RYSOWANIA:
            // cx = poziomo (np. co 50 pikseli), cy = pionowo (z danych z pliku)
            double x = 50 + (i * 40);
            double y = 600 - (r.getKolumna2() * 2); // Odejmujemy od dołu, bo w SVG (0,0) to góra!
            double promien = 10;

            // TUTAJ MOŻESZ DOPISAĆ WARUNEK: np. jeśli wartość > średnia, to kółko jest zielone
            String kolor = (r.getKolumna2() > srednia) ? "green" : "red";

            // Budujemy kółko i podpis pod nim
            String kolko = "<circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"" + promien + "\" fill=\"" + kolor + "\" />";
            String tekst = "<text x=\"" + (x - 10) + "\" y=\"" + (y - 20) + "\" font-size=\"12\" fill=\"black\">" + r.getKolumna1() + "</text>";

            svg.dodaj(kolko);
            svg.dodaj(tekst);
        }

        // --- 5. FINISH ---
        svg.zapisz("wynik_kolokwium.svg");
        System.out.println("🚀 Plik SVG wygenerowany. Speedrun zakończony sukcesem!");
    }
}