public class SprawdzaczTekstu {

    // ==========================================================
    // GOTOWIEC 4: WALIDATOR DANYCH (REGEX)
    // Sprawdza, czy tekst pasuje do ustalonego wzorca.
    // ==========================================================
    public static boolean czyPoprawnyKodPocztowy(String tekst) {

        // .matches() to potężna broń.
        // "\\d" oznacza "dowolna cyfra (0-9)".
        // {2} oznacza "dokładnie dwa razy".
        // Czyli: 2 cyfry, myślnik, 3 cyfry.
        return tekst.matches("\\d{2}-\\d{3}");
    }

    public static boolean czyToSamaLiczba(String tekst) {
        //
