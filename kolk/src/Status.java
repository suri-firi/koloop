// ==========================================================
// GOTOWIEC 2: ENUM (Zbiór stałych wartości)
// Zamiast "class" jest "enum".
// ==========================================================
public enum Status {

    ZDROWE,
    ZAKAZONE,
    ZMARLE,
    NIEZNANE; // Zawsze warto mieć opcję awaryjną

    // Metoda pomocnicza - zamienia tekst z pliku CSV w naszego Enuma
    public static Status zTekstu(String tekstZPliku) {
        // Usuwamy spacje i robimy wielkie litery, żeby uniknąć błędów
        String czystyTekst = tekstZPliku.trim().toUpperCase();

        switch (czystyTekst) {
            case "ZDROWE": return ZDROWE;
            case "ZAKAZONE": return ZAKAZONE;
            case "ZMARLE": return ZMARLE;
            default: return NIEZNANE;
        }
    }
}

/* JAK TEGO UŻYĆ W KLASIE "Rekord"?
   Zamiast: private String kategoria;
   Piszesz: private Status kategoria;
   
   W konstruktorze pliku CSV:
   this.kategoria = Status.zTekstu(kolumny[2]);
*/