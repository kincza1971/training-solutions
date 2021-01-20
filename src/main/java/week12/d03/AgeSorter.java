package week12.d03;

import java.util.*;

public class AgeSorter {
    public int[] sortAges(int[] ages) {
        boolean unsorted = true;
        int puffer;
        while (unsorted) {
            unsorted = isUnsorted(ages,false);
        }
        return ages;
    }

    private boolean isUnsorted(int[] ages, boolean unsorted) {
        int puffer;
        for (int i = 0; i< ages.length-1; i++) {
            if (ages[i] > ages[i+1]) {
                puffer = ages[i];
                ages[i] = ages[i+1];
                ages[i+1] = puffer;
                unsorted = true;
            }
        }
        return unsorted;
    }

    public int[] sortAges2(int[] ages) {
        int[] counter = new int[131];
        for (int i : ages) {
            counter[i]++;
        }
        int[] sorted = new int[ages.length];
        int idx =0;
        for (int i = 0; i<131;i++) {
            if (counter[i]>0) {
                for (int j = 0; j < counter[i]; j++) {
                    sorted[idx] = i;
                    idx++;
                }
            }
        }
        return sorted;
    }


    public static void main(String[] args) {
        AgeSorter ageSorter = new AgeSorter();
        boolean ok = true;
        System.out.println(Arrays.toString(ageSorter.sortAges2(new int[]{7,4,23,99,39,41,55,99,4,8,29})));
    }

}
