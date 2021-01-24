package exceptionmulticatch.converter;

public class BinaryStringConverter {
    public boolean[] binaryStringToBooleanArray(String boolString) {
        boolean[] boolArray = new boolean[boolString.length()];
        int counter = 0;
        for (char c : boolString.toCharArray()) {
            if(c == '1') {
                boolArray[counter] = true;
            } else {
                if (c != '0') {
                    throw new IllegalArgumentException("Invalid char in the string: " +c);
                }
            }
            counter++;
        }
        return boolArray;
    }

    public String booleanArrayToBinaryString(boolean[] boolArray) {
        if (boolArray == null || boolArray.length ==0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        StringBuilder sb = new StringBuilder(boolArray.length);
        for (boolean b : boolArray) {
            sb.append(b? "1" : "0");
        }
        return sb.toString();
    }
}
