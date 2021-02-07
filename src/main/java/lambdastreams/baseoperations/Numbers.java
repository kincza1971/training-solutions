package lambdastreams.baseoperations;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> integers;

    public Numbers(List<Integer> integers) {
        this.integers = integers;
    }

    private static boolean isPositive(Integer m) {
        return m > 0;
    }

    public Optional min() {
        OptionalInt optionalInt = integers.stream().mapToInt(Integer::intValue).min();
        if (optionalInt.isPresent()) {
            Optional<Integer> optional = Optional.of((Integer) optionalInt.getAsInt());
            return optional;
        }
        return Optional.empty();
    }

    public int sum() {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isAllPositive() {
        return integers.stream().allMatch(Numbers::isPositive);
    }

    public List<Integer> getDistinctElements () {
        return integers.stream().distinct().collect(Collectors.toList());
    }
}

//min(): a legkisebb szám,
//sum(): az elemek összege,
//isAllPositive(): megvizsgálja, hogy minden elem pozitív-e,
//getDistinctElements(): az összes különböző elemet pontosan egyszer tartalmazó kollekció.