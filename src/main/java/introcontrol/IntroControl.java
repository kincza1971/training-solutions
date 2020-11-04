package introcontrol;

public class IntroControl {

    public IntroControl() {
    }

    public int substractTenIfGreaterThanTen(int number) {
      if (number   >10) {
          number = number -10;
      }
      return number;
    }

    public String describeNumber(int number) {
        String res;
        if (number == 0) {
            res = "Zero";
        }  else {
            res= "not zero";
        }
        return res;
    }

    public String greetingToJoe(String name) {
        String res;
        if (name.equals("Joe")) {
            res = "Hello Joe";
        } else {
            res= "";
        }
        return res;
    }

    public int calculateConsumption(int prev, int next) {
        int res;
        if (next < prev) {
            res = 9999-prev + next;
        } else {
            res = next-prev;
        }
        return res;
    }

    public void printNumbersBetweenAnyDirection(int a, int b) {
        if (a<=b) {
            for (int i = a; (i <= b); i++) {
                System.out.println(i + " ");
            }
        } else {
            for (int i = a; (i >= b); i--) {
                System.out.print(i + " ");
            }
        }
    }

    public void printOddNumbers(int max) {
        for (int i =1; i<=max; i=i+2) {
            System.out.print(i+" ");
        }
    }
}
