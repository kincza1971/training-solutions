package exceptions.polinom;

import com.sun.source.tree.TryTree;

import java.util.Collection;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.toRadians;

public class Polynomial {

    private double[] polValues;
    private String redValues;

    public double evaluate(double x) {
        double result = 0;
        double b = 0;
        for (int i = polValues.length-1;i>=0 ; i--) {
            result += polValues[i]*pow(x,b);
            b++;
        }
        return result;
    }

    public double[] getCoefficients() {
        return polValues;
    }

    private void checkParam(double[] redValues) {
        if (redValues == null) {
            throw new NullPointerException ("coefficients is null");
        }
    }

    private void checkParam(String[] redValues) {
        if (redValues == null) {
            throw new NullPointerException ("coefficientStrs is null");
        }
    }

    public Polynomial(double[] polValues) {
        checkParam(polValues);
        this.polValues = polValues;
    }

    private void parseDouble(int i, String s) {
        try {
            polValues[i] = Double.parseDouble(s.replace(",","."));
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", ex);
        }
    }



    public Polynomial(String[] redValues) {
        checkParam(redValues);
        int i =0;
        polValues = new double[redValues.length];
        for (String s : redValues) {
            parseDouble(i, s);
            i++;
        }
    }

}
