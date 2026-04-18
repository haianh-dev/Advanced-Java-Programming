package bai10.code;

import java.util.Scanner;

class Employee {
    String name;
    double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return 0.1 * baseSalary;
    }

    public void getInfo() {
        System.out.println(name + " - Bonus: " + calculateBonus());
    }
}

class Developer extends Employee {
    int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public double calculateBonus() {
        return 0.1 * baseSalary + (overtimeHours * 200000);
    }

    public void getInfo() {
        System.out.println(name + " - Bonus: " + calculateBonus());
    }
}

class Tester extends Employee {
    int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    public double calculateBonus() {
        return 0.1 * baseSalary + (bugsFound * 50000);
    }

    public void getInfo() {
        System.out.println(name + " - Bonus: " + calculateBonus());
    }
}

public class Main {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien: ");
        int getEmployeesCount = sc.nextInt();
        Employee[] employeesList = new Employee[getEmployeesCount];

        for (int i = 0; i < getEmployeesCount; i++) {
            System.out.println("Nhap loai nhan vien: ");
            String employeeObject = sc.next();

            if (employeeObject.equals("E")) {
                System.out.println("Nhap ten nhan vien: ");
                String name = sc.next();
                System.out.println("Nhap luong co ban cua nhan vien: ");
                double baseSalary = sc.nextDouble();
                sc.nextLine();
                employeesList[i] = new Employee(name, baseSalary);
            } else if (employeeObject.equals("D")) {
                System.out.println("Nhap ten nhan vien: ");
                String name = sc.next();
                System.out.println("Nhap luong co ban cua nhan vien: ");
                double baseSalary = sc.nextDouble();
                System.out.println("Nhap so gio lam them: ");
                int overtimeHours = sc.nextInt();
                sc.nextLine();
                employeesList[i] = new Developer(name, baseSalary, overtimeHours);
            } else if (employeeObject.equals("T")) {
                System.out.println("Nhap ten nhan vien: ");
                String name = sc.next();
                System.out.println("Nhap luong co ban cua nhan vien: ");
                double baseSalary = sc.nextDouble();
                System.out.println("Nhap so loi tim thay: ");
                int bugsFound = sc.nextInt();
                sc.nextLine();
                employeesList[i] = new Tester(name, baseSalary, bugsFound);
            }
        }
        System.out.println();

        for (Employee emp: employeesList) {
            if (emp instanceof Developer) {
                emp.getInfo();
                System.out.println("Tang khoa hoc AWS");
                System.out.println();
            } else if (emp instanceof Tester) {
                emp.getInfo();
                System.out.println("Tang tool Test");
                System.out.println();
            } else {
                emp.getInfo();
                System.out.println();
            }
        }
    }
}