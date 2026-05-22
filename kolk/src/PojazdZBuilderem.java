public class PojazdZBuilderem {
    // Pola obiektu, które będziemy budować
    private String marka;
    private int moc;
    private String kolor;

    // PRYWATNY KONSTRUKTOR! (Tylko Builder może go użyć)
    private PojazdZBuilderem(Builder budowniczy) {
        this.marka = budowniczy.marka;
        this.moc = budowniczy.moc;
        this.kolor = budowniczy.kolor;
    }

    // ==========================================================
    // KLASA BUILDER (Wewnętrzna klasa - to jest najważniejsze!)
    // ==========================================================
    public static class Builder {
        // Kopiujesz te same zmienne co wyżej
        private String marka;
        private int moc;
        private String kolor;

        // Metoda 1 (Każda metoda musi zwracać "this")
        public Builder ustawMarke(String marka) {
            this.marka = marka;
            return this; // <--- MAGIA ŁAŃCUSZKA KROPEK
        }

        // Metoda 2
        public Builder ustawMoc(int moc) {
            this.moc = moc;
            return this;
        }

        // Metoda 3
        public Builder ustawKolor(String kolor) {
            this.kolor = kolor;
            return this;
        }

        // FINAŁ: Zbudowanie gotowego obiektu
        public PojazdZBuilderem zbuduj() {
            return new PojazdZBuilderem(this);
        }
    }

    /* JAK TEGO UŻYĆ W MAINIE? Kopiuj to do Maina, gdy odetną neta:
    PojazdZBuilderem auto = new PojazdZBuilderem.Builder()
            .ustawMarke("Skoda")
            .ustawMoc(110)
            .ustawKolor("Czerwony")
            .zbuduj();
    */
}