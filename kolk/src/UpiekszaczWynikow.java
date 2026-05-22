public class UpiekszaczWynikow {

    // ==========================================================
    // GOTOWIEC 4: OBCINANIE BRZYDKICH UŁAMKÓW DO 2 MIEJSC PO PRZECINKU
    // ==========================================================
    public static String zaokraglij(double brzydkaLiczba) {

        // %.2f oznacza ułamek z dokładnością do 2 miejsc po przecinku.
        // Jeśli chcesz 3 miejsca, wpisujesz %.3f

        // UWAGA: String.format czasem wstawia polski przecinek zamiast kropki,
        // co może zepsuć SVG! Zastępujemy ewentualny przecinek kropką:
        String ladnaLiczba = String.format("%.2f", brzydkaLiczba);
        return ladnaLiczba.replace(",", ".");
    }

    /* JAK TEGO UŻYĆ W MAINIE?
       double srednia = 10.123456789;
       System.out.println("Średnia to: " + UpiekszaczWynikow.zaokraglij(srednia));
       // Wypluje: Średnia to: 10.12
    */
}