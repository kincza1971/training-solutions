package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    public List<Type> whichType(String s) {
        List<Type> result = new ArrayList<>();
        long number = Long.parseLong(s);
        for (Type aType : Type.values()) {
            if ((aType.getMinValue()<=number)&&(aType.getMaxValue()>=number)) {
                result.add(aType);
            }
        }
        return result;
    }
}
