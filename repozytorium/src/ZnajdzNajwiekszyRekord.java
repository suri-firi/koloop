// ====================================================================
// WTYCZKA 3: SZUKANIE NAJWIĘKSZEGO ELEMENTU W LIŚCIE
// Użycie: Modyfikujesz w klasie Main pod swoje wczytane dane z CSV.
// ====================================================================
public static void znajdzNajwiekszyRekord(java.util.List<Rekord> listaDanych) {

    // Zabezpieczenie przed pustym plikiem
    if (listaDanych.isEmpty()) return;

    // Zakładamy na start, że pierwszy element z listy jest tym "największym"
    Rekord lider = listaDanych.get(0);

    // Przechodzimy przez całą listę
    for (Rekord aktualny : listaDanych) {

        // INSTRUKCJA: Tutaj musisz użyć swojego gettera z klasy Rekord!
        // Zamień getKolumna2() na metodę, którą chcesz badać (np. getPopulacja())
        if (aktualny.getKolumna2() > lider.getKolumna2()) {
            // Znaleźliśmy kogoś większego! Zmiana lidera.
            lider = aktualny;
        }
    }

    System.out.println("Największą wartość ma: " + lider.toString());
}

void main() {
}