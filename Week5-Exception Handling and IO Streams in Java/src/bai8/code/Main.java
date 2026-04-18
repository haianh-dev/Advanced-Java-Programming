package bai8.code;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten tep: ");
        String nameFile = scanner.nextLine();

        writeData(nameFile, scanner);

        readData(nameFile);

        scanner.close();
    }

    public static void writeData(String nameFile, Scanner scanner) {
        System.out.print("Nhap so luong so nguyen n: ");
        int n = scanner.nextInt();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nameFile))) {
            for (int i = 0; i < n; i++) {
                System.out.print("Nhap so thu " + (i + 1) + ": ");
                int number = scanner.nextInt();
                dos.writeInt(number);
            }
            System.out.println("- Da ghi xong " + n + " so vao tep: " + nameFile);
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public static void readData(String nameFile) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nameFile))) {
            while (true) {
                int number = dis.readInt();
                System.out.print(number + " ");
            }
        } catch (EOFException e) {
            System.out.println("\n- Da doc het du lieu trong tep.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file hoac file khong ton tai: " + e.getMessage());
        }
    }
}

