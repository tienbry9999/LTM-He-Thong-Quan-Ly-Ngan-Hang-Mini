package SuDungRMI;

import java.io.Serializable;

public class Fraction implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numerator;   // tử số
    private int denominator; // mẫu số

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Mẫu số không thể bằng 0");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    private void simplify() {
        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= g;
        denominator /= g;
        if (denominator < 0) { numerator *= -1; denominator *= -1; }
    }

    private int gcd(int a, int b) {
        while (b != 0) { int t = a % b; a = b; b = t; }
        return a == 0 ? 1 : a;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
