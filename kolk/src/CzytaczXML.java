import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class CzytaczXML {

    // ==========================================================
    // GOTOWIEC 4: AUTOMATYCZNE CZYTANIE XML/SVG (Jackson)
    // ==========================================================

    // Załóżmy, że masz w Javie klasę Mapka (z polami takimi jak tagi w XML)
    public static void czytajZAutomatu(String sciezkaDoXml) {
        try {
            // Tworzymy super-narzędzie
            XmlMapper mapper = new XmlMapper();

            // W JEDNEJ LINIJCE plik w magiczny sposób zamienia się w gotowy obiekt!
            // Zmień "TwojaKlasa.class" na klasę, którą masz w zadaniu.
            TwojaKlasa wynik = mapper.readValue(new File(sciezkaDoXml), TwojaKlasa.class);

            System.out.println("Zjedzono i przetrawiono XML z sukcesem!");

        } catch (Exception e) {
            System.out.println("Biblioteka Jackson nie dała rady, albo XML jest zepsuty.");
        }
    }
}