// ====================================================================
// WTYCZKA 6: GRUPOWANIE I ZLICZANIE (Słownik / HashMap)
// Import wymaga: java.util.HashMap; oraz java.util.Map;
// ====================================================================
public static void zliczWystapienia(java.util.List<Rekord> listaDanych) {

    java.util.Map<String, Integer> liczniki = new java.util.HashMap<>();

    for (Rekord r : listaDanych) {
        String klucz = r.getKolumna1(); // Zmień na to, co chcesz zliczać (np. nazwa kraju)

        if (liczniki.containsKey(klucz)) {
            // Jeśli już widzieliśmy ten kraj, dodaj 1 do licznika
            liczniki.put(klucz, liczniki.get(klucz) + 1);
        } else {
            // Jeśli to nowy kraj, ustaw na 1
            liczniki.put(klucz, 1);
        }
    }

    // Ładne wypisanie wyników pętlą
    for (String klucz : liczniki.keySet()) {
        System.out.println(klucz + " występuje: " + liczniki.get(klucz) + " razy.");
    }
}