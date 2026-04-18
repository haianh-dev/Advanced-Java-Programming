package bai3.code;

class MathUtils {
    public int sum(int a, int b) {
        return a + b;
    }
}

public class AdvancedMath extends MathUtils {
    public int sum(int a, int b) {
        return a + b + 10;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public void main(String[] args) {
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5,5));
        // System.out.println(m.sum(5.5,5.5); //
    }
}
