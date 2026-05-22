public class WykrywaczKolizji {

    // ==========================================================
    // GOTOWIEC 2: SPRAWDZANIE CZY DWA PROSTOKĄTY SIĘ NAKŁADAJĄ
    // Zakładamy, że masz parametry x, y (lewy górny róg) i szerokość, wysokość.
    // Zwraca true jeśli jest kraksa, false jeśli są od siebie daleko.
    // ==========================================================
    public static boolean czySieZderzaja(double x1, double y1, double szer1, double wys1,
                                         double x2, double y2, double szer2, double wys2) {

        // Warunek kolizji - jeśli wszystkie 4 są prawdziwe, to prostokąty się przecinają
        boolean warunekPrawaKrawedz = (x1 + szer1) >= x2;
        boolean warunekLewaKrawedz = x1 <= (x2 + szer2);
        boolean warunekDolnaKrawedz = (y1 + wys1) >= y2;
        boolean warunekGornaKrawedz = y1 <= (y2 + wys2);

        // Zwracamy wynik połączenia tych warunków (&& to znaczy "I")
        return warunekPrawaKrawedz && warunekLewaKrawedz && warunekDolnaKrawedz && warunekGornaKrawedz;
    }
}