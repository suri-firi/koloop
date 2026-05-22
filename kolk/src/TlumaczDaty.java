import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TlumaczDaty {

    // ==========================================================
    // GOTOWIEC 2: ZAMIANA GŁUPIEGO TEKSTU NA PRAWDZIWĄ DATĘ
    // ==========================================================
    public static LocalDate ogarnijDate(String dziwnyTekstZPliku) {

        // TUTAJ ZMIENIASZ WZÓR:
        // "M/d/yy"  -> dla dat typu 4/23/21
        // "dd.MM.yyyy" -> dla dat typu 23.04.2021
        // "yyyy-MM-dd" -> dla dat typu 2021-04-23
        DateTimeFormatter wzor = DateTimeFormatter.ofPattern("M/d/yy");

        try {
            // Próbuje zamienić tekst na datę używając wzoru
            return LocalDate.parse(dziwnyTekstZPliku, wzor);

        } catch (Exception e) {
            System.out.println("🚨 Alarm! Nie umiem przeczytać daty: " + dziwnyTekstZPliku);
            // Zwraca "dzisiaj" awaryjnie, żeby program nie wybuchł
            return LocalDate.now();
        }
    }
    
    /* JAK TEGO UŻYĆ W KLASIE "Rekord" (w konstruktorze z tablicą)?
       this.mojaData = TlumaczDaty.ogarnijDate(kolumny[0]);
    */
}