package typeconversion.dataloss;

public class DataLoss {

    public void dataloss() {
        float floatNumber = 0.0f;
        double doubleNumber = 0.0;
        do {
            doubleNumber++;
            floatNumber = (float) doubleNumber;
        }while(floatNumber == doubleNumber);
        long result;
        for (int i = 0; i<3; i++) {
            result = (int) doubleNumber;
            System.out.println((doubleNumber +i));
            System.out.println(Integer.toBinaryString((int) result) + " (" +Integer.toBinaryString((int) result).length() +")");
        }
    }


    public static void main(String[] args) {
        DataLoss dataLoss = new DataLoss();
        dataLoss.dataloss();

    }
}
