// ====================================================================
// WTYCZKA 5: SORTOWANIE LISTY OBIEKTÓW PO KONKRETNYM POLU
// Użycie: W Main, gdy już wczytasz dane do listy "mojeDane".
// Import wymaga: java.util.Collections; oraz java.util.Comparator;
// ====================================================================
public static void posortujListe(java.util.List<Rekord> listaDanych) {

    java.util.Collections.sort(listaDanych, new java.util.Comparator<Rekord>() {
        @Override
        public int compare(Rekord r1, Rekord r2) {
            // INSTRUKCJA: Zamień getKolumna2() na to, po czym chcesz sortować!
            // Jeśli chcesz od najmniejszego do największego: Double.compare(r1..., r2...)
            // Jeśli chcesz od NAJWIĘKSZEGO do najmniejszego (malejąco) – zamień kolejność (r2, r1):
            return Double.compare(r2.getKolumna2(), r1.getKolumna2());
        }
    });

    System.out.println("Posortowano!");
}