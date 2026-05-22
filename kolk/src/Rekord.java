// ==========================================================
// GOTOWIEC 3: KLASA, KTÓRA SAMA UMIE SIĘ SORTOWAĆ
// Dopisek "implements Comparable<Rekord>" jest obowiązkowy!
// ==========================================================
public class Rekord implements Comparable<Rekord> {

    private String nazwa;
    private double wartosc;

    // ... (tutaj masz swoje konstruktory i gettery z poprzednich wiadomości) ...

    // TĘ METODĘ MUSISZ DOPISAĆ NA SAMYM DOLE KLASY!
    @Override
    public int compareTo(Rekord innyRekord) {
        // INSTRUKCJA DLA MAŁPY:
        // Jeśli chcesz sortować po LICZBACH (np. wartosc):
        // (Użyj Double.compare dla liczb z przecinkiem, Integer.compare dla intów)
        return Double.compare(this.wartosc, innyRekord.wartosc);

        // ALBO! Jeśli każą Ci posortować ALFABETYCZNIE po tekście (np. nazwa miasta):
        // return this.nazwa.compareTo(innyRekord.nazwa);
    }
    
    /* JAK TEGO UŻYĆ W MAINIE?
       Zamiast wielkiego bloku kodu, piszesz tylko to i Java robi resztę:
       Collections.sort(listaWczytanaZPliku);
    */
}