package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> chain = new ArrayList<>();

    public void addLast(String last) {
        chain.add(last);
    }

    public void addFirst(String first) {
            chain.add(0,first);
    }

    public void removeFirst() {
        chain.remove(0);
    }

    public void removeLast(){
        chain.remove(chain.size()-1);
    }

    public List<String> getChain() {
        return chain;
    }

    public static void main(String[] args) {
        Capsules cps = new Capsules();
        cps.addFirst("kék");
        System.out.println(cps.getChain().toString());
        cps.addFirst("sárga");
        System.out.println(cps.getChain().toString());
        cps.addLast("sárga");
        System.out.println(cps.getChain().toString());
        cps.addLast("piros");
        System.out.println(cps.getChain().toString());
        cps.addLast("kék");
        cps.addFirst("narancs");
        System.out.println(cps.getChain().toString());
        cps.addLast("sárga");
        System.out.println(cps.getChain().toString());
        cps.addLast("kék");
        System.out.println(cps.getChain().toString());

        cps.removeLast();
        System.out.println(cps.getChain().toString());
        cps.removeFirst();
        System.out.println(cps.getChain().toString());


    }
}
