package primitivetypes;

public class PrimitiveTypes {

    public String toBinaryString(int number) {
        String result ="";
        int length = 32;
        do {
            result =  (number % 2 ==0 ? "0":"1") + result;
            number = number/2;
        } while (number>0);
        length = length-result.length();
        for (int i=0;i<length;i++) {
            result = "0"+result;
        }
        return result;
    }
    public static void main(String[] args) {
        PrimitiveTypes pm = new PrimitiveTypes();
        String myBin = pm.toBinaryString(1000);
        String sysBin = Integer.toBinaryString(1000);

        int length = 32;
        length = length-sysBin.length();
        for (int i=0;i<length;i++) {
            sysBin = "0"+sysBin;
        }
        System.out.println("számolt 32 hosszon: " + myBin);
        System.out.println("javastring 32 hosszon: " + sysBin);
        System.out.println(sysBin.equals(myBin) ? "Megegyezik" : "nem Egyezik meg");

    }
}
