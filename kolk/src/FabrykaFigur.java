public class FabrykaFigur {

    // ==========================================================
    // GOTOWIEC 2: WZORZEC FABRYKA
    // Produkuje różne obiekty na podstawie zwykłego tekstu.
    // Wymaga, żeby Kolo i Kwadrat dziedziczyły po klasie (lub interfejsie) Figura.
    // ==========================================================

    // Metoda statyczna - działa jak maszyna wydająca produkty
    public static Figura stworzFigure(String nazwa, int rozmiar) {

        // Zmieniamy na małe litery, żeby się nie martwić czy ktoś wpisał "KOLO" czy "kolo"
        String typ = nazwa.toLowerCase();

        switch (typ) {
            case "kolo":
                // Zwraca konkretny obiekt typu Kolo
                return new Kolo(rozmiar);

            case "kwadrat":
                return new Kwadrat(rozmiar);

            default:
                // Gdy ktoś poprosi o coś, czego nie mamy:
                throw new IllegalArgumentException("Nie znam takiej figury: " + nazwa);
        }
    }

    /* JAK TEGO UŻYĆ W MAINIE?
       Figura f1 = FabrykaFigur.stworzFigure("kolo", 50);
       Figura f2 = FabrykaFigur.stworzFigure("kwadrat", 100);
    */
}