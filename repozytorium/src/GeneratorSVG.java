import java.io.FileWriter;

public class GeneratorSVG {
    private String zawartosc = "";
    private int szerokosc;
    private int wysokosc;

    public GeneratorSVG(int szerokosc, int wysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    // Tę metodę będziesz wołać w pętli w Main
    public void dodaj(String tagSvg) {
        this.zawartosc += "\t" + tagSvg + "\n";
    }

    public void zapisz(String sciezka) {
        try {
            FileWriter writer = new FileWriter(sciezka);
            writer.write("<svg width=\"" + szerokosc + "\" height=\"" + wysokosc + "\" xmlns=\"http://www.w3.org/2000/svg\">\n");
            writer.write(zawartosc);
            writer.write("</svg>");
            writer.close();
            System.out.println("Zapisano SVG do: " + sciezka);
        } catch (Exception e) {
            System.out.println("Błąd zapisu pliku!");
        }
    }
}