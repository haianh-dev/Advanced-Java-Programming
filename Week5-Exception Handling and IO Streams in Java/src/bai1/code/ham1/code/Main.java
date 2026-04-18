package bai1.code.ham1.code;

public class Main {
    public void main(String[] args) {
        String string = "";

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            string = string + "Hello";
        }

        long end= System.currentTimeMillis();
        System.out.println("Thoi gian thuc thi: " + (end - start) + " ms");
    }
}
