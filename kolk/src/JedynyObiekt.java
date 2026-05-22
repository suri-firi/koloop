// ==========================================================
// GOTOWIEC 3: WZORZEC SINGLETON (Zawsze tylko jedna instancja w programie)
// ==========================================================
public class JedynyObiekt {

    // KROK 1: Ukryta, statyczna zmienna trzymająca tę jedyną instancję.
    private static JedynyObiekt jedynaKopia;

    public String jakasWartosc = "Tajne dane";

    // KROK 2: PRYWATNY KONSTRUKTOR! Nikt z zewnątrz nie może zrobić "new JedynyObiekt()"
    private JedynyObiekt() {
        System.out.println("Tworzę jedyny obiekt na cały program!");
    }

    // KROK 3: Globalny punkt dostępu
    public static JedynyObiekt pobierzInstancje() {
        if (jedynaKopia == null) {
            jedynaKopia = new JedynyObiekt(); // Tworzy tylko za pierwszym razem!
        }
        return jedynaKopia;
    }

    /* JAK TEGO UŻYĆ W MAINIE?
     Zamiast: JedynyObiekt x = new JedynyObiekt(); (to wywali błąd)
     Piszesz: JedynyObiekt x = JedynyObiekt.pobierzInstancje();
    */
}