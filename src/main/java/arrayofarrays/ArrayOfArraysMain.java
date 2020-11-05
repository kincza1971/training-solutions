package arrayofarrays;


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

    public static void main(String[] args) {
        ArrayOfArraysMain am = new ArrayOfArraysMain();

        am.printArrayOfArrays(am.multiplicationTable(12));
        System.out.println();
        am.printArrayOfArrays(am.triangularMatrix(5));
        System.out.println();
        am.printArrayOfArrays(am.getValues());
    }
}
