import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class KalkulatorDni {

    // ==========================================================
    // GOTOWIEC 3: LICZENIE DNI / MIESIĘCY MIĘDZY DATAMI
    // Wymaga importu java.time.temporal.ChronoUnit;
    // ==========================================================
    public static long policzRoznice(LocalDate dataPoczatkowa, LocalDate dataKoncowa) {

        // Zwraca w wyniku samą liczbę (typ long, czyli taki wielki int)
        // Możesz zmienić DAYS na WEEKS, MONTHS lub YEARS!
        return ChronoUnit.DAYS.between(dataPoczatkowa, dataKoncowa);
    }

    /* JAK TEGO UŻYĆ W MAINIE?
       LocalDate start = LocalDate.of(2021, 1, 1);
       LocalDate koniec = LocalDate.of(2021, 1, 15);
       
       long dni = KalkulatorDni.policzRoznice(start, koniec);
       System.out.println("Minęło " + dni + " dni."); // Wypisze: 14
    */
}