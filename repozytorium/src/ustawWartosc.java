// ====================================================================
// WTYCZKA 2: RZUCANIE BŁĘDU (Gdy dane z pliku lub od użytkownika są złe)
// Użycie: Kopiujesz ten fragment IF i wklejasz do jakiejkolwiek metody,
// która musi sprawdzać warunki (np. gdy sekundy w zegarze są > 60)
// ====================================================================
public void ustawWartosc(int wartosc) {

    // --- KOPIUJESZ OD TEGO MIEJSCA ---
    if (wartosc < 0 || wartosc > 100) {
        // Zmień warunek w nawiasie na to, czego wymaga zadanie!
        throw new IllegalArgumentException("Halo! Podano nieprawidlowa wartosc: " + wartosc);
    }
    // --- DO TEGO MIEJSCA ---

    // Jeśli kod przejdzie przez IFa i nie rzuci błędu, idzie dalej normalnie:
    System.out.println("Wartość ustawiona pomyślnie na: " + wartosc);
}
