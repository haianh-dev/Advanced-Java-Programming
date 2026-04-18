package bai7.code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bai7.code.Student.filterStudent;
import static bai7.code.Student.sortStudent;

interface Operation<T> {
    T execute(T a, T b);
}

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    public static void filterStudent(List<Student> students) {
        students.removeIf(student -> student.getGpa() < 5.0);
    }

    public static void sortStudent(List<Student> students) {
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

public class Main {
    Operation<Integer> add = (a,b) -> a + b;
    Operation<Integer> sub = (a,b) -> a - b;
    Operation<Integer> multiply = (a,b) -> a * b;
    Operation<Integer> divide = (a,b) -> a / b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap ma ID, ten, gpa sinh vien: ");
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students[i] = new Student(id, name, gpa);
        }

        List<Student> studentList = new ArrayList<>(Arrays.asList(students));

        filterStudent(studentList);
        System.out.println("After removing GPA < 5.0 : ");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();

        sortStudent(studentList);
        System.out.println("After sorting by name: ");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
