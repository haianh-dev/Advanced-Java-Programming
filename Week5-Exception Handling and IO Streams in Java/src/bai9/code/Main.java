package bai9.code;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', gpa=" + gpa + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameFile = "students.dat";

        displayStudentList(nameFile, scanner);
        docDanhSachSinhVien(nameFile);
        scanner.close();
    }

    public static void displayStudentList(String tenFile, Scanner scanner) {
        List<Student> studentList = new ArrayList<>();

        System.out.println("- Nhap danh sach sinh vien: ");
        while (true) {
            System.out.print("Nhap ID (go 'END' de dung): ");
            String id = scanner.nextLine();

            if (id.equals("END")) {
                break;
            }

            System.out.print("Nhap ten: ");
            String name = scanner.nextLine();

            System.out.print("Nhap GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();

            Student sv = new Student(id, name, gpa);
            studentList.add(sv);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))) {
            for (Student sv : studentList) {
                oos.writeObject(sv);
            }
            System.out.println("- Da ghi thanh cong danh sach vào tep " + tenFile);
        } catch (IOException e) {
            System.out.println("Loi I/O khi ghi file: " + e.getMessage());
        }
    }

    public static void docDanhSachSinhVien(String tenFile) {
        System.out.println("\n- Doc danh sach sinh vien tu tep");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFile))) {
            while (true) {
                Student sv = (Student) ois.readObject();
                System.out.println(sv.toString());
            }
        } catch (EOFException e) {
            System.out.println("- Da doc het danh sach sinh vien.");
        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay tep " + tenFile);
        } catch (ClassNotFoundException e) {
            System.out.println("Loi: Khong tim thay lop Student de ep kieu: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi I/O khi doc file: " + e.getMessage());
        }
    }
}
