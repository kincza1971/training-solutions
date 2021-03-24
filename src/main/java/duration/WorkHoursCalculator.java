package duration;

import java.time.Duration;

public class WorkHoursCalculator {

    private Duration workTime = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        workTime = workTime.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        workTime = workTime.plusDays(days).plusHours(hours).plusMinutes(minutes);
    }

    public void addWorkTime(String durationString) {
        workTime = workTime.plus(Duration.parse(durationString));
    }

    public int calculateWorkHours() {
        return (int) workTime.toHours();
    }

    public Duration getWorkDuration() {
        return workTime;
    }

//    @Override
//    public String toString() {
//        return ;
//    }

}

//Programozási munka során rögzíteni kívánjuk, hogy az egyes funkciók kidolgozására mennyi időt fordítottunk.
// Készítsünk egy WorkHoursCalculator osztályt, amely ezt megvalósítja, az egyes időtartamokat legyünk képesek
// többféleképpen is bevinni, a beviteleket a rendszer összegzi, és lekérdezhetjük Duration formájában, megjeleníthetjük
// String-ként valamint kiszámíthatjuk az összes ráfordított időt munkaórákban.
//
//Hibakezelés
//Parszolás esetén a String nem lehet üres. Ezt kivételkezeléssel biztosítsuk, null vagy üres String esetén dobjon
// IllegalArgumentException-t a megfelelő szöveggel. Hasonlóképpen, ha a String paraméter nem üres, de a parszolás mégsem
// hajtható végre, dobjon IllegalArgumentException-t a megfelelő szöveggel.
//
//Megvalósítási javaslatok
//A Duration objektum esetében a nap-óra-perc Stringgé alakításnál próbáljuk a Duration saját metódusait használni!
//
//publikus metódusok:
//
//public void addWorkTime(Duration duration)
//public void addWorkTime(int days, int hours, int minutes)
//public void addWorkTime(String durationString)
//public int calculateWorkHours()
//public Duration getWorkDuration()
//public String toString()
