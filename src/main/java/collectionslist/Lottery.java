package collectionslist;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }

        List<Integer> numbers = IntStream.range(1, ballCount + 1)
                                        .boxed()
                                        .collect(Collectors.toList());

        Collections.shuffle(numbers);
        return numbers.stream().limit(lotteryType).sorted().collect(Collectors.toList());
    }
}
