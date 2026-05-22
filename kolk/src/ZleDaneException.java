// ==========================================================
// GOTOWIEC 1: TWORZENIE WŁASNEGO BŁĘDU (WYJĄTKU)
// Słowo "extends RuntimeException" to klucz do sukcesu.
// Dzięki niemu program wie, że to jest błąd, który może wywalić apkę.
// ==========================================================
public class ZleDaneException extends RuntimeException {

    // Konstruktor, do którego przekażesz wiadomość o błędzie
    public ZleDaneException(String wiadomosc) {
        super(wiadomosc); // "super" wysyła wiadomość do głównego systemu błędów Javy
    }
    
    /* JAK TEGO UŻYĆ W INNYM PLIKU (np. w klasie Rekord)?
     public void ustawWiek(int wiek) {
         if (wiek < 0) {
             // Zamiast System.out.println rzucasz swój nowy, lśniący wyjątek!
             throw new ZleDaneException("Wiek nie może być mniejszy niż zero! Podano: " + wiek);
         }
         this.wiek = wiek;
     }
    */
}