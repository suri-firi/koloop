public class Rekord {
    // 1. ZMIENNE: Tutaj wpisujesz to, co masz w kolumnach pliku CSV
    private String nazwa;
    private double wartosc;

    // 2. KONSTRUKTOR: Do tworzenia obiektu ręcznie (np. w testach)
    public Rekord(String nazwa, double wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    // 3. KONSTRUKTOR "POD PLIK": Tutaj dzieje się magia czytania
    public Rekord(String[] kolumny) {
        // kolumny[0] to pierwsza szufladka z pociętej linii, [1] to druga itd.
        this.nazwa = kolumny[0];

        // ZMIANA TYPU: Tekst na liczbę. Jeśli wolisz liczby całkowite, użyj Integer.parseInt
        this.wartosc = Double.parseDouble(kolumny[1]);
    }

    // 4. GETTERY: Potrzebne, żeby Main mógł "wyciągnąć" te dane do rysowania SVG
    public String getNazwa() { return nazwa; }
    public double getWartosc() { return wartosc; }

    @Override
    public String toString() {
        return "Rekord[" + nazwa + " : " + wartosc + "]";
    }
}