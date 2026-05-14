// ====================================================================
// WTYCZKA 7: CZYTANIE I ZAMIANA DATY Z TEKSTU
// Import wymaga: java.time.LocalDate; oraz java.time.format.DateTimeFormatter;
// Użycie: Gdy w CSV masz dziwną datę, dodajesz w Rekord.java pole LocalDate
// i używasz tego w konstruktorze zamiast Double.parseDouble.
// ====================================================================
public static java.time.LocalDate zamienTekstNaDate(String tekstZPliku) {

    // Wzór musi pasować do pliku!
    // MM/dd/yy = np. 04/23/21
    // d.MM.yyyy = np. 5.03.1990 (jak w Twoim family.csv!)
    // yyyy-MM-dd = standard 2024-05-12
    java.time.format.DateTimeFormatter wzor = java.time.format.DateTimeFormatter.ofPattern("M/d/yy");

    try {
        return java.time.LocalDate.parse(tekstZPliku, wzor);
    } catch (Exception e) {
        System.out.println("Nie udało się przeczytać daty: " + tekstZPliku);
        // Zwracamy dzisiejszą datę jako awarię, żeby program nie wybuchł
        return java.time.LocalDate.now();
    }
}
