// ==========================================================
// GOTOWIEC 1: INTERFEJS (Kontrakt dla różnych klas)
// Słowo "interface" to obietnica: "Każdy, kto mnie zaimplementuje,
// MUSI posiadać metody, które tu wymienię".
// ==========================================================
public interface Rysowalny {

    // Zauważ brak klamerek {}! To tylko wymóg, nie gotowy kod.
    String wygenerujSVG();
}

/* JAK TEGO UŻYĆ? 
  1. W klasie np. Kolo dodajesz: public class Kolo implements Rysowalny { ... }
     I musisz w niej dopisać metodę: public String wygenerujSVG() { return "<circle...>"; }
  
  2. W klasie Main robisz JEDNĄ listę na wszystko:
     List<Rysowalny> wszystkieFigury = new ArrayList<>();
     wszystkieFigury.add(new Kolo());
     wszystkieFigury.add(new Kwadrat());
     
     for (Rysowalny figura : wszystkieFigury) {
         svg.dodaj(figura.wygenerujSVG()); // <--- Magia Polimorfizmu!
     }
*/