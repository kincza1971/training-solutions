package interacedefaultmethods.print;

public class Printer {

    public String print (Printable toPrint) {
        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i<toPrint.getLength(); i++) {
            if (!toPrint.getColor(i).equals("#000000")) {
                sb.append("[" + toPrint.getColor(i) + "]");
            }
            sb.append(toPrint.getPage(i)+"\n");
        }
        return sb.toString();
    }
}
