package bai5.code;
import java.util.Scanner;

class FullTimeEmployee extends Employee {
    double baseSalary;
    double bonus;
    double penalty;

    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public double totalSalary() {
        return baseSalary + (bonus - penalty);
    }

    public void getInfo() {
        System.out.println(name + " - Full-time - " + totalSalary());
    }
}

class PartTimeEmployee extends Employee {
    double workingHours;
    double hourlyRate;

    public PartTimeEmployee(String name,double workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public double totalSalary() {
        return workingHours * hourlyRate;
    }

    public void getInfo() {
        System.out.println(name + " - Part-time - " + totalSalary());
    }
}

public abstract class Employee {
    String name;
    String birthday;
    String id;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double totalSalary();
    public abstract void getInfo();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien: ");
        int employees = sc.nextInt();
        Employee [] employeelist = new Employee[employees];

        for (int i = 0; i < employees; i++) {
            System.out.println("Nhap kieu nhan vien: ");
            String emptype = sc.next();
            sc.nextLine();
            System.out.println("Nhap ten nhan vien: ");
            String name = sc.nextLine();

            if (emptype.equals("F")) {
                System.out.println("Nhap baseSalary: ");
                double baseSalary = sc.nextDouble();
                System.out.println("Nhap bonus: ");
                double bonus = sc.nextDouble();
                System.out.println("Nhap penalty: ");
                double penalty = sc.nextDouble();
                employeelist[i] = new FullTimeEmployee(name, baseSalary, bonus, penalty);
            } else if (emptype.equals("P")) {
                System.out.println("Nhap workingHours: ");
                double workingHours = sc.nextDouble();
                System.out.println("Nhap hourlyRate: ");
                double hourlyRate = sc.nextDouble();
                employeelist[i] = new PartTimeEmployee(name, workingHours, hourlyRate);
            }
        }

        for (Employee emp: employeelist) {
            emp.getInfo();
        }

    }
}
