public class SkalerWartosci {

    // ==========================================================
    // GOTOWIEC 1: MAPOWANIE DANYCH NA EKRAN (Skalowanie)
    // Zamienia wielkie liczby z CSV na małe piksele na ekranie.
    // ==========================================================
    public static double mapuj(double wartosc, double stareMin, double stareMax, double noweMin, double noweMax) {

        // Zabezpieczenie przed dzieleniem przez zero (gdyby wszystkie liczby w pliku były takie same)
        if (stareMax - stareMin == 0) {
            return noweMin;
        }

        // Klasyczny matematyczny wzór na mapowanie wartości (Interpolacja Liniowa)
        return ((wartosc - stareMin) / (stareMax - stareMin)) * (noweMax - noweMin) + noweMin;
    }

    /* JAK TEGO UŻYĆ PRZY GENEROWANIU SVG W MAINIE?
       Załóżmy, że najmniejsza wartość w pliku to 0, a największa to 1000000 (milion).
       A na ekranie chcesz to rysować od y=50 do y=750.

       double pozycjaY = SkalerWartosci.mapuj(mojRekord.getWartosc(), 0, 1000000, 50, 750);

       Teraz Twój wykres ZAWSZE idealnie zmieści się na ekranie, niezależnie od danych!
    */
}