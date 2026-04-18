package Bai3.code;

public class NumberWrapper {
    private int value;

    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public static void swap(NumberWrapper a, NumberWrapper  b) {
        NumberWrapper temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper();
        n1.setValue(5);

        NumberWrapper n2 = new NumberWrapper();
        n2.setValue(10);

        System.out.println("Truoc khi doi vi tri: n1: " + n1.getValue() + ", n2: " + n2.getValue());

        swap(n1, n2);

        System.out.println("Sau khi doi vi tri: n1: " + n1.getValue() + ", n2: " + n2.getValue());
    }
}

