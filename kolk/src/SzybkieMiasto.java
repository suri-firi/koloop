// ==========================================================
// GOTOWIEC 1: RECORD (Klasa w 1 linijce)
// Słowo "class" zamieniasz na "record". 
// Podajesz zmienne w nawiasie i... GOTOWE.
// ==========================================================
public record SzybkieMiasto(String nazwa, int populacja, double powierzchnia) {

    // NIE PISZESZ TU ZUPEŁNIE NIC! 
    // Java sama zrobiła konstruktor, gettery i toString!
}

/* JAK TEGO UŻYĆ W MAINIE?
   SzybkieMiasto m = new SzybkieMiasto("Lublin", 340000, 147.5);
   
   // Uwaga! Gettery w rekordach nie mają słowa "get"!
   System.out.println(m.nazwa()); 
   System.out.println(m.toString()); // Wypluje od razu ładne: SzybkieMiasto[nazwa=Lublin, ...]
*/