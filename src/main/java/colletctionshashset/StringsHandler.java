package colletctionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        Set set = new HashSet(stringCollection);
        return set;
    }
    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {
        setA.retainAll(setB);
        return setA;
    }


}
