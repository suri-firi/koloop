public class Rekord {
    private String kolumna1;
    private double kolumna2;

    public Rekord(String kolumna1, double kolumna2) {
        this.kolumna1 = kolumna1;
        this.kolumna2 = kolumna2;
    }

    public Rekord(String[] kolumny) {
        this.kolumna1 = kolumny[0];
        this.kolumna2 = Double.parseDouble(kolumny[1]);
    }

    public String getKolumna1() { return kolumna1; }
    public double getKolumna2() { return kolumna2; }

    @Override
    public String toString() {
        return "Rekord[" + kolumna1 + " : " + kolumna2 + "]";
    }
}