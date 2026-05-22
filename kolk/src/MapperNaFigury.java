public class MapperNaFigury {

    // ==========================================================
    // GOTOWIEC 3: MAPOWANIE OBIEKTÓW (Data Transfer Object -> Model)
    // ==========================================================

    // To jest nasz interfejs (Złota zasada, żeby było profesjonalnie)
    public interface Mapper<T, R> {
        // T - Typ wejściowy (np. Rekord)
        // R - Typ wyjściowy (np. String z kodem SVG)
        R mapuj(T wejscie);
    }

    // A to jest konkretna maszyna, która implementuje ten interfejs
    public static class RekordNaKoloMapper implements Mapper<Rekord, String> {

        @Override
        public String mapuj(Rekord wejscie) {
            // Wyciskamy dane z rekordu i robimy z nich koło
            double promien = wejscie.getKolumna2() / 10; // dzielimy, zeby nie bylo za wielkie
            String nazwa = wejscie.getKolumna1();

            // Zwracamy od razu gotowy kod do SVG
            return "<circle r=\"" + promien + "\" title=\"" + nazwa + "\" />";
        }
    }

    /* JAK TEGO UŻYĆ W MAINIE?
       RekordNaKoloMapper zamieniacz = new RekordNaKoloMapper();

       for(Rekord r : daneZPliku) {
           String gotoweKolo = zamieniacz.mapuj(r);
           svg.dodaj(gotoweKolo);
       }
    */
}