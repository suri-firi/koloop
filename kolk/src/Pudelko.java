// ==========================================================
// GOTOWIEC 4: KLASA GENERYCZNA (Szablon dla dowolnego typu)
// Literka <T> oznacza "Dowolny Typ, podam go dopiero przy tworzeniu obiektu".
// ==========================================================
public class Pudelko<T> {

    // Zmienna trzyma "coś" o typie T
    private T zawartosc;

    public Pudelko(T zawartosc) {
        this.zawartosc = zawartosc;
    }

    public T wyciagnij() {
        return zawartosc;
    }

    public void podmien(T nowaZawartosc) {
        this.zawartosc = nowaZawartosc;
    }
}

/* JAK TEGO UŻYĆ W MAINIE?
   Pudelko<String> pudelkoNaNapis = new Pudelko<>("Tajne Haslo");
   Pudelko<Integer> pudelkoNaLiczbe = new Pudelko<>(999);
   Pudelko<Rekord> pudelkoNaNaszeDane = new Pudelko<>(mojRekord);
*/