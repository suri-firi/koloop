public class SzablonRodziny {

    // ==========================================================
    // GOTOWIEC 3: KLASA MATKA (Abstrakcyjna - nie da się zrobić z niej obiektu)
    // ==========================================================
    public abstract static class Matka {
        // "protected" znaczy: widoczne tylko dla mnie i moich dzieci
        protected String nazwisko;

        public Matka(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        // Metoda abstrakcyjna = "Zmuszam moje dzieci, żeby to napisały!"
        public abstract void dajGlos();
    }

    // ==========================================================
    // KLASA CÓRKA (Dziedziczy po Matce - używa słowa "extends")
    // ==========================================================
    public static class Corka extends Matka {
        private int wiek;

        public Corka(String nazwisko, int wiek) {
            // "super" wywołuje konstruktor Matki i daje jej nazwisko
            super(nazwisko);
            this.wiek = wiek;
        }

        // Córka MUSI zrealizować obietnicę Matki (dajGlos)
        @Override
        public void dajGlos() {
            System.out.println("Jestem corką! Mam nazwisko " + this.nazwisko + " i mam " + wiek + " lat.");
        }
    }
}