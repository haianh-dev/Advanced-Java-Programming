package Bai4.code;

class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
}

public class Employee {
    private String name;
    private MyDate birthday;

    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Employee(Employee otherEmployee) {
        this.name = otherEmployee.name;
        this.birthday = new MyDate(
                otherEmployee.birthday.getDay(),
                otherEmployee.birthday.getMonth(),
                otherEmployee.birthday.getYear()
        );
    }

    public static void main(String[] args) {
        MyDate birthday1 = new MyDate(1, 1, 2000);
        Employee emp1 = new Employee("emp1", birthday1);
        Employee emp2 = new Employee(emp1);

        birthday1.setDay(2);
        birthday1.setMonth(2);
        birthday1.setYear(2022);

        System.out.println("Ngay sinh cua emp2 la: "
                + emp2.birthday.getDay()
                + "/" + emp2.birthday.getMonth()
                + "/" + emp2.birthday.getYear()
        );
    }
}