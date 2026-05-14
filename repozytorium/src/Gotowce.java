public class Gotowce {

    // ====================================================================
    // WTYCZKA 1: LICZENIE ODLEGŁOŚCI MIĘDZY PUNKTAMI (Wzór Pitagorasa)
    // Użycie: W pliku Main wpisujesz:
    // double wynik = Gotowce.policzOdleglosc(10, 10, 50, 50);
    // ====================================================================
    public static double policzOdleglosc(double x1, double y1, double x2, double y2) {
        // Math.pow(liczba, 2) to potęgowanie do kwadratu
        // Math.sqrt() to pierwiastek z całości
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }