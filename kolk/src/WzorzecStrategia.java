public class WzorzecStrategia {

    // 1. INTERFEJS (To jest nasz "pilot" od telewizora)
    public interface SposobRysowania {
        String narysuj(double x, double y);
    }

    // 2. PIERWSZA STRATEGIA (np. Rysuj jako czerwone kółko)
    public static class StrategiaCzerwona implements SposobRysowania {
        @Override
        public String narysuj(double x, double y) {
            return "<circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"10\" fill=\"red\"/>";
        }
    }

    // 3. DRUGA STRATEGIA (np. Rysuj jako zielony kwadrat)
    public static class StrategiaZielona implements SposobRysowania {
        @Override
        public String narysuj(double x, double y) {
            return "<rect x=\"" + x + "\" y=\"" + y + "\" width=\"20\" height=\"20\" fill=\"green\"/>";
        }
    }

    // 4. TWÓJ GŁÓWNY OBIEKT (np. Wykres), który może wymieniać strategie jak rękawiczki
    public static class Wykres {
        // Zmienna trzymająca "aktualny" sposób rysowania
        private SposobRysowania aktualnaStrategia;

        // Metoda do dynamicznej zmiany (podmiana w trakcie działania programu!)
        public void zmienStrategie(SposobRysowania nowaStrategia) {
            this.aktualnaStrategia = nowaStrategia;
        }

        public void wygenerujWykres(double x, double y) {
            // Wykres nie obchodzi, CZYM aktualnie rysuje. Po prostu naciska "narysuj".
            System.out.println(aktualnaStrategia.narysuj(x, y));
        }
    }

    /* JAK TEGO UŻYĆ W MAINIE?
       Wykres mojWykres = new Wykres();

       // Ustawiamy strategię na czerwoną i rysujemy
       mojWykres.zmienStrategie(new StrategiaCzerwona());
       mojWykres.wygenerujWykres(50, 50); // Wypluje kółko

       // Oho! Zmiana planów! Zmieniamy na zieloną i rysujemy dalej!
       mojWykres.zmienStrategie(new StrategiaZielona());
       mojWykres.wygenerujWykres(100, 100); // Wypluje kwadrat
    */
}