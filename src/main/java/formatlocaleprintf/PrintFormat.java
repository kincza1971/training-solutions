package formatlocaleprintf;


import java.util.Locale;

public class PrintFormat {

    public String checkException(String formatString, Integer i, Integer j) {
        boolean found = true;
        int fromIndex=0;
        int counter =0;
        while(found) {
            if (formatString.indexOf("%d",fromIndex) >0){
                fromIndex = formatString.indexOf("%d",fromIndex) +1;
                counter++;
            } else {
                found = false;
            }
        }
        if (counter !=2){
            throw new IllegalArgumentException("Less objects then expected in format String!");
        }
        return "" ;
    }

    public String printFormattedText(Double number) {
        return String.format(new Locale("hu","HU"),"Total is: %,8.2f Ft", number );
    }
    public String formatMessageWithIntegerParameters(String formatString, Integer i, Integer j){
        checkException(formatString,i,j);
        return String.format(formatString,i,j);
    }
    public String printFormattedText(int count, String fruit) {
        return String.format("We counted %d %s in the basket",count,fruit);
    }
    public String printFormattedText(int number) {
        return String.format("Right edge of numbers set at 4 spaces from text:%4d",number);
    }
    public String printFormattedText(int i, int j, int k) {
        return String.format("Multiple objects containing text:%d\t%d\t%d", i, j,k);
    }
}
