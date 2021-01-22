package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {



    public String numberOfDaysAsString() {
        int[] numberOfDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        return Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat","Vasárnap");
    }

    public String multiplicationTableAsString(int size) {
        String[] table = new String[size];
        for (int i=0; i<size; i++) {
            int[] aRow = new int[size];
            for (int j=0;j<size; j++) {
                aRow[j] = (j+1)*(i+1);
            }
            table[i] = Arrays.toString(aRow);
        }
        return Arrays.toString(table);
    }

    public boolean wonLottery(int[] winner, int[] bet) {
        Arrays.sort(winner);
        Arrays.sort(bet);
        return Arrays.equals(winner,bet);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day,anotherDay);
    }

    private int getMinIndex (int a, int b) {
        return a>b ? b : a;
    }

    public boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int size = getMinIndex(day.length, anotherDay.length);
        return Arrays.equals(day,0,size, anotherDay,0,size);
    }

    public static void main(String[] args) {
        ArraysMain am = new ArraysMain();
        System.out.println(am.numberOfDaysAsString());
        System.out.println(am.daysOfWeek());
        System.out.println(am.multiplicationTableAsString(5));
        System.out.println(am.sameTempValues(new double[]{1.1,2.2,3.3,4.4},new double[]{4.4,1.1,2.2,3.3}));
        int[] winner = {71,5,10,6,90};
        System.out.println(am.wonLottery(winner, new int[] {5,10,90,6,71}));
        System.out.println(Arrays.equals(winner,new int[] {5,6,10,71,90}));
        System.out.println(am.sameTempValuesDaylight(new double[]{1.1,2.2,3.3,4.4,6.6,6.7},new double[]{1.1,2.2,3.3,4.4}));
    }
}
