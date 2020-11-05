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
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res[i][j] = (i + 1) * (j + 1);
            }
        }
        return res;
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

    public static void main(String[] args) {
        ArrayOfArraysMain am = new ArrayOfArraysMain();

        am.printArrayOfArrays(am.multiplicationTable(5));
        System.out.println();
        am.printArrayOfArrays(am.triangularMatrix(5));

    }
}
