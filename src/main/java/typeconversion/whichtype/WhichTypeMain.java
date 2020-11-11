package typeconversion.whichtype;

import java.util.List;

public class WhichTypeMain {

    public void printList(List<Type> aList) {
        String toPrint = "";
        for (Type aType : aList) {
            toPrint = toPrint + aType.name() + ", ";
        }
        System.out.println("Típusok: " + toPrint);
    }

    public static void main(String[] args) {
        WhichTypeMain wtm = new WhichTypeMain();
        WhichType whichType = new WhichType();

        wtm.printList(whichType.whichType("127"));
        wtm.printList(whichType.whichType("-128"));
        wtm.printList(whichType.whichType("-32768"));
        wtm.printList(whichType.whichType("32767"));
        wtm.printList(whichType.whichType("-125000"));
        wtm.printList(whichType.whichType("125000"));
        wtm.printList(whichType.whichType("1111111111111111"));
    }
}
