// ==========================================================
// GOTOWIEC 4: SZYBKI STRING BUILDER (Zamiast plusem łączyć napisy)
// To podbija wydajność programu 100-krotnie. Używaj w GeneratorSVG!
// ==========================================================
public class SzybkiZlepiacz {

    // Używamy profesjonalnego narzędzia Javy zamiast zwykłego Stringa
    private StringBuilder duzyTekst = new StringBuilder();

    public void dopiszLinijke(String tag) {
        // Zamiast duzyTekst += tag, robimy .append()
        duzyTekst.append(tag).append("\n");
    }

    // Gdy na koniec chcesz to np. zapisać do pliku, musisz zmienić to na String
    public String pobierzCalyTekst() {
        return duzyTekst.toString();
    }
    
    /*
      JAK TEGO UŻYĆ ZAMIAST ZWYKŁEGO "+="?
      SzybkiZlepiacz zlepiacz = new SzybkiZlepiacz();
      for(int i=0; i<1000; i++) {
          zlepiacz.dopiszLinijke("<circle cx='10'/>"); // Szybko, bez laga!
      }
      System.out.println(zlepiacz.pobierzCalyTekst());
    */
}