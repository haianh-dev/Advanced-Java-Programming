package bai3.code;
import java.util.Scanner;

interface IWorkable {
    void work();
}

abstract class Employee implements IWorkable {
    String id;
    String name;
    double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();

    public abstract void getInfo();
}

class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return baseSalary;
    }

    @Override
    public void work() {
        System.out.println("Soan thao van ban");
    }

    @Override
    public void getInfo() {
        System.out.println(name + " - Pay: " + calculatePay());
    }
}

class Technician extends Employee {
    double overtimeHours;

    public Technician(String id, String name, double baseSalary, double overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }

    @Override
    public void work() {
        System.out.println("Lap dat thiet bi");
    }

    @Override
    public void getInfo() {
        System.out.println(name + " - Pay: " + calculatePay());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien: ");
        int emp = sc.nextInt();
        Employee [] employees = new Employee[emp];

        for (int i = 0; i < emp; i++) {
            System.out.println("Nhap loai nhan vien: ");
            String typeEmp = sc.next();

            if (typeEmp.equals("O")) {
                System.out.println("Nhap id, ten, luong goc nhan vien van phong: ");
                String id = sc.next();
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                employees[i] = new OfficeWorker(id, name, baseSalary);
            } else if (typeEmp.equals("T")) {
                System.out.println("Nhap id, ten, luong, so gio lam them cua ky thuat vien: ");
                String id = sc.next();
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                double overtimeHours = sc.nextDouble();
                employees[i] = new Technician(id, name, baseSalary, overtimeHours);
            }
        }
        System.out.println();

        double totalPay = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.getInfo();
                employee.work();
                System.out.println();
                totalPay += employee.calculatePay();
            }
        }

        System.out.println("Total Pay = " + totalPay);
    }
}
