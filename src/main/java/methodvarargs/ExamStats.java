package methodvarargs;

import static java.lang.Math.round;

public class ExamStats {
    private final int maxPoints;


    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    private void checkAnArray(int[] array) {
        if(array.length ==0) {
            throw new IllegalArgumentException ("Empty array");
        }
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        checkAnArray(results);
        int topLimit = (int) round((double) maxPoints * limitInPercent/100);
        int counter = 0;
        for (int i : results) {
            if (i>= topLimit) {
                counter++;
            }
        }
        return counter;

    }
    public boolean hasAnyFailed(int limitInPercent, int... results) {
        checkAnArray(results);
        int failedBelow = (int) round((double) maxPoints * limitInPercent/100);
        for (int i : results) {
            if (i< failedBelow) {
                return true;
            }
        }
        return false;
    }
}
