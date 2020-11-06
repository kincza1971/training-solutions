package arrayofarrays;

import java.util.Arrays;
import java.util.List;


public class ArrayOfArraysMain {

    public int[][] triangularMatrix(int size) {
        int[][] mtrx = new int[size][];
        for (int i = 0; i < size; i++) {
            mtrx[i] = new int[i+1];
            for (int j = 0; j <=i; j++) {
                mtrx[i][j] = i;
            }
        }
        return mtrx;
    }

    public int[][] multiplicationTable(int size) {
        int[][] mtrx = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mtrx[i][j] = (i + 1) * (j + 1);
            }
        }
        return mtrx;
    }

    void printArrayOfArrays(int[][] a) {
        String toPrint = "";
        for (int i = 0; i < a.length; i++) {
            for (int j : a[i]) {
                toPrint = "   " + j;;
                System.out.print(toPrint.substring(toPrint.length()-4,toPrint.length()));
            }
            System.out.println();
        }
    }

    public int[][] getValues() {
        int[][] mtrx = new int[12][];
        int days;
        for (int i = 1; i <13; i++) {
            switch (i) {
                case 4: case 6: case 9: case 11:
                    days =30;
                    break;
                case 2:
                    days =28;
                    break;
                default :
                    days = 31;
            }
            mtrx[i-1] = new int[days]; // kezdőérték int esetén magától 0
        }
        return mtrx;
    }

    public String numberOfDaysAsString() {
        int[] number = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(number);
    }

    List<String> daysOfWeek() {
        String[] dayOW = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        return Arrays.asList(dayOW);
    }

    String multiplicationTableAsString(int size) {
        int[][] mt = multiplicationTable(size);
        String res = "";
        for (int[] arr : mt) {
            res = res + Arrays.toString(arr);
        }
        return res;
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        int hours = day.length<anotherDay.length ? day.length : anotherDay.length;
        double[] copyDay = Arrays.copyOfRange(day, 0, hours-1);
        double[] copyAnotherDay = Arrays.copyOfRange(anotherDay, 0, hours-1);
        return Arrays.equals(copyDay, copyAnotherDay);
    }

    public boolean wonLottery(int[] bet, int[] res) {

        int[] copybet = Arrays.copyOf(bet,5);
        int[] copyres = Arrays.copyOf(res,5);
        Arrays.sort(copybet);
        Arrays.sort(copyres);
        return Arrays.equals(copybet, copyres);
    }

    public static void main(String[] args) {
        ArrayOfArraysMain am = new ArrayOfArraysMain();

        am.printArrayOfArrays(am.multiplicationTable(12));

        System.out.println();
        am.printArrayOfArrays(am.triangularMatrix(5));

        System.out.println();
        am.printArrayOfArrays(am.getValues());

        System.out.println();
        System.out.println(am.numberOfDaysAsString());

        System.out.println(am.daysOfWeek());
        System.out.println(am.multiplicationTableAsString(5));


        double[] day = {13.12, 15.15, 16.16, 17.17, 18.18, 19.19, 20.20, 21.21, 22.22, 21.21, 20.20 };
        double[] anotherDay ={13.12, 15.15, 16.16, 17.17, 18.18, 19.19, 20.20, 21.21, 22.22, 21.21, 20.20, 19.19};
        System.out.println((am.sameTempValues(day, anotherDay)) ? "Egyezik" : "Nem egyezik");


        int[] bet ={19,7,23,81,4};
        int[] res ={7,23,81,4,19};
        System.out.println(am.wonLottery(bet, res)?  "Nyert" : "Nem nyert");

       // Arrays.equals(bet,Arrays.sort(bet));
    }
}
