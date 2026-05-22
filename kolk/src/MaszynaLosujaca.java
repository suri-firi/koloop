import java.util.Random;

public class MaszynaLosujaca {

    // Tworzymy generator - najlepiej raz, żeby działał szybko
    private static final Random GENERATOR = new Random();

    // ==========================================================
    // GOTOWIEC 4: ZAAWANSOWANE LOSOWANIE LICZB I KOLORÓW
    // ==========================================================

    // Losuje liczbę całkowitą z wybranego przedziału (od Min do Max)
    public static int losujLiczbe(int min, int max) {
        // Magiczna formuła na losowanie w przedziale
        return GENERATOR.nextInt((max - min) + 1) + min;
    }

    // Losuje profesjonalny kolor w formacie HEX dla SVG (np. #FF00A1)
    public static String losujKolorHex() {
        // Losuje 3 liczby (Red, Green, Blue) od 0 do 255
        int r = GENERATOR.nextInt(256);
        int g = GENERATOR.nextInt(256);
        int b = GENERATOR.nextInt(256);

        // Formatuje to do postaci #RRGGBB (wygląda super w SVG!)
        return String.format("#%02x%02x%02x", r, g, b).toUpperCase();
    }
    
    /* JAK TEGO UŻYĆ PRZY TWORZENIU SVG?
       String kolor = MaszynaLosujaca.losujKolorHex();
       int losowyX = MaszynaLosujaca.losujLiczbe(0, 800);
       
       String kółko = "<circle cx='" + losowyX + "' cy='100' r='10' fill='" + kolor + "' />";
    */
}