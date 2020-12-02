package week06.d03;

import java.util.List;

public class Series {


    private boolean isIncremental(int a0, int a1){
        return a0 < a1;
    }

    private void checkList(List<Integer> integers) {
        if (integers == null || integers.size()<2) {
            throw new IllegalArgumentException("List cannot be null or shorter than 2 element");
        }

    }

    public Results calculateSeriesType(List<Integer> integers) {
        checkList(integers);
        boolean isInc = isIncremental(integers.get(0),integers.get(1));
        for (int i = 2; i< integers.size();i++) {
            if (isInc != isIncremental(integers.get(i-1), integers.get(i))) {
                return Results.UNSORT;
            }
        }
        if (isInc) {
            return Results.INC;
        }
        return Results.DEC;
    }
}
