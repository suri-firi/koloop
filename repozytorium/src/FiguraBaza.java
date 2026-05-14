// ====================================================================
// WTYCZKA 4: SZABLON DZIEDZICZENIA (Klasa Rodzic i Dziecko)
// Instrukcja: To są osobne klasy, musisz je skopiować do osobnych plików,
// jeśli zadanie tego wymaga. Tu trzymasz je tylko jako "ściągę" składni!
// ====================================================================

// Klasa bazowa (Rodzic). Słowo 'abstract' znaczy, że nie można zrobić 'new FiguraBaza()'
public abstract class FiguraBaza {
    protected String kolor; // protected znaczy: "widoczne dla mnie i moich dzieci"

    public FiguraBaza(String kolor) {
        this.kolor = kolor;
    }

    // Metoda abstrakcyjna = "każde dziecko MUSI to mieć, ale nie mówię jak ma działać"
    public abstract String generujSVG();
}

// Klasa dziedzicząca (Dziecko). Słowo 'extends' oznacza dziedziczenie!
public class KoloDziedzic extends FiguraBaza {
    private int promien;

    public KoloDziedzic(String kolor, int promien) {
        super(kolor); // super() odpala konstruktor Rodzica (przekazuje mu kolor)
        this.promien = promien;
    }

    // Dziecko MUSI zaimplementować tę metodę
    @Override
    public String generujSVG() {
        return "<circle r=\"" + promien + "\" fill=\"" + this.kolor + "\"/>";
    }
}
} // <--- Koniec klasy Gotowce