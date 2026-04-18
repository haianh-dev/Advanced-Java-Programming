package bai6.code;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhap a: ");
            int a = sc.nextInt();
            System.out.println("Nhap b: ");
            int b = sc.nextInt();

            System.out.println("Ket qua phep chia a/b: " + a/b);
        } catch (InputMismatchException e) {
            System.out.println("Loi: Nhap sai kieu du lieu!");
        } catch (ArithmeticException e) {
            System.out.println("Loi: Khong the chia cho 0!");
        } finally{
            System.out.println("Program finished.");
        }
    }
}
