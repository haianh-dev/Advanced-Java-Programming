package bai7.code;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap duong dan tep nguon: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Nhap duong dan tep dich: ");
        String destPath = scanner.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int copiedLineCount = 0;
        boolean isSuccess = false;

        try {
            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new PrintWriter(new FileWriter(destPath));

            String line;

            while ((line = reader.readLine()) != null) {
                writer.println(line);
                copiedLineCount++;
            }
            isSuccess = true;

        } catch (FileNotFoundException e) {
            File srcFile = new File(sourcePath);
            if (!srcFile.exists()) {
                System.out.println("Source file not found.");
            } else {
                System.out.println("Cannot create destination file.");
            }
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Loi khi dong tep doc.");
            }

            if (writer != null) {
                writer.close();
            }
        }

        if (isSuccess) {
            System.out.println("Sao chep thanh cong! So dong da sao chep: " + copiedLineCount);
        }

        scanner.close();
    }
}
