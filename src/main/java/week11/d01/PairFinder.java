package week11.d01;

import java.util.Set;
import java.util.TreeSet;

public class PairFinder {

    public int findPairs(int[] arr) {
        int result =0;
        int counter = 0;
        Set<Integer> unPaired = new TreeSet<>();
        for (int n : arr) {
            unPaired.add(n);
            if(counter == unPaired.size()) {
                unPaired.remove(n);
                result++;
                counter--;
            } else {
                counter++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PairFinder pf = new PairFinder();
        System.out.println(pf.findPairs(new int[]{5, 1, 4, 5}));
        System.out.println(pf.findPairs(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));

    }
}
