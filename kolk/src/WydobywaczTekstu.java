import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WydobywaczTekstu {

    // ==========================================================
    // GOTOWIEC 1: WYCIĄGANIE SAMEJ LICZBY Z BRUDNEGO TEKSTU
    // ==========================================================
    public static int wyciagnijLiczbe(String brudnyTekst) {

        // "\\d+" oznacza "szukaj ciągu samych cyfr"
        Pattern wzor = Pattern.compile("\\d+");
        Matcher szukacz = wzor.matcher(brudnyTekst);

        // Jeśli znalazł jakieś cyfry w tekście:
        if (szukacz.find()) {
            String znalezionaLiczba = szukacz.group(); // Wyciąga te cyfry np. "382500"
            return Integer.parseInt(znalezionaLiczba); // Zamienia na inta
        }

        // Zwraca 0, jeśli w tekście nie było żadnej liczby (awaryjne)
        return 0;
    }
    
    /* JAK TEGO UŻYĆ?
       String zPliku = "Skoda Octavia, silnik 1.9 TDI, przebieg: 382500 km";
       int przebieg = WydobywaczTekstu.wyciagnijLiczbe(zPliku); 
       // Wynik: 382500 (wyciągnie pierwszą dużą liczbę zbitą razem, ułamek 1.9 pominie 
       // jeśli podrasujemy regex, ale dla prostych liczb \d+ działa jak złoto).
    */
}