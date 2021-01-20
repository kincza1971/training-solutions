package week12.d03;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class NumberStat {
    public Integer selectLowestUniqueNumber(int[] numbers) {
        checkArray(numbers);
        Set<Integer> uniqueSet = createUniqSet(numbers);
        return getResult(uniqueSet);
    }

    private Integer getResult(Set<Integer> uniqueSet) {
        Iterator<Integer> it = uniqueSet.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new IllegalArgumentException("There is no unique number in array");
    }

    private Set<Integer> createUniqSet(int[] numbers) {
        Set<Integer> uniqueSet = new TreeSet<>();
        for (int number : numbers) {
            uniqueSet.add(number);
        }
        return uniqueSet;
    }

    private void checkArray(int[] numbers) {
        if (numbers == null || numbers.length ==0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
    }
}
