package exceptionmulticatch.converter;

import static java.lang.Math.round;

public class AnswerStat {
    private final BinaryStringConverter bsc = new BinaryStringConverter();
    public boolean[] convert(String boolString) {
        try {
            return bsc.binaryStringToBooleanArray(boolString);
        } catch (NumberFormatException e) {
            throw new InvalidBinaryString("Invalid binary string",e);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] boolResult = convert(answers);
        double countAll =0;
        int countTrue = 0;
        for (boolean b : boolResult) {
            if (b) {
                countTrue++;
            }
            countAll++;
        }
        return (int) round(countTrue/countAll*100);
    }
}
