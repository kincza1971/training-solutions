package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] napok = {"Hétfő", "Kedd", "Szerda", "Cütörtök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println(napok[1]);

        boolean[] logikai = new boolean[6];


        for (boolean igaze : logikai) {
            System.out.println(igaze);
        }

        for (int i =0; i< logikai.length;i++) {
            logikai[i] = true;
        }

        for (boolean igaze : logikai) {
            System.out.println(igaze);
        }

        for (int i =0; i< logikai.length;i++) {
            logikai[i] = false;
        }

        for (boolean igaze : logikai) {
            System.out.println(igaze);
        }

//        for (boolean igaze : logikai) {
//            igaze = true;
//        }
//        for (boolean igaze : logikai) {
//            System.out.println(igaze);
//        }

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                numbers[i]=2;
            } else {
                numbers[i] = numbers[i-1]*2;
            }
            System.out.println(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i]= (int) Math.pow(2,i+1);
            System.out.println(numbers[i]);
        }


    }
}
