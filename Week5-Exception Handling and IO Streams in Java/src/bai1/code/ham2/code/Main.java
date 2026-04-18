package bai1.code.ham2.code;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        StringBuffer stringBuffer = new StringBuffer(1000000000);

        for (int i = 0; i < 100000; i++) {
            stringBuffer.append("Hello World");
        }

        long end = System.currentTimeMillis();
        System.out.println("Thoi gian thuc thi: " + (end-start) + " ms");
    }
}
