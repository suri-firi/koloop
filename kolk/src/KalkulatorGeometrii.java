public class KalkulatorGeometrii {

    // ==========================================================
    // GOTOWIEC 1: LICZENIE ODLEGŁOŚCI MIĘDZY DWOMA PUNKTAMI
    // Używa słynnego twierdzenia Pitagorasa.
    // Zwraca w wyniku ułamek (double).
    // ==========================================================
    public static double policzOdleglosc(double x1, double y1, double x2, double y2) {

        // Math.pow(liczba, 2) to potęgowanie do kwadratu
        double a = Math.pow(x2 - x1, 2);
        double b = Math.pow(y2 - y1, 2);

        // Math.sqrt() to pierwiastek z całości
        return Math.sqrt(a + b);
    }

    /* JAK TEGO UŻYĆ W MAINIE?
       double dystans = KalkulatorGeometrii.policzOdleglosc(10, 10, 50, 50);
       System.out.println("Odległość to: " + dystans);
    */
}