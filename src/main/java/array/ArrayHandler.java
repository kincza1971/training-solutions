package array;

public class ArrayHandler {
    public boolean contains(int[] source, int itemToFind) {
        boolean res = false;
        for (int i : source) {

            if (i == itemToFind) {
                res = true;
            }
        }
        return res;
    }

    public int find(int[] source, int itemToFind) {
        int res = -1;
        for (int i : source ) {
            if (i == itemToFind){
                res = i;          // itt akkor van gond, ha többször szerepel, mert akkor az utolsó index megy vissza
            }
        }
        return res;
    }

}
