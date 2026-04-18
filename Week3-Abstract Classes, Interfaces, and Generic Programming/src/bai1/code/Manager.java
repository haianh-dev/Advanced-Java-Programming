package bai1.code;

class Person {
    String name;
    String dob;

    public Person(String name) {
        this.name = name;
        System.out.println("1. Person is created");
    }
}

class Employee extends Person {
    double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
        System.out.println("2. Employee is created");
    }
}

public class Manager extends Employee {
    String department;

    public Manager(String name, double salary, String department) {
        super(name,salary);
        this.department = department;
        System.out.println("3. Manager is created");
    }

    public static void main(String[] args) {
        Manager m = new Manager("Nam", 1000, "Human Resources Department");
    }
}
