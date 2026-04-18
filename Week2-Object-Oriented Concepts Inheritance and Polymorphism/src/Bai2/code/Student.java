package Bai2.code;

public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.setGPA(gpa);
    }

    public Student(Student otherStudent) {
        this.id = otherStudent.id;
        this.name = otherStudent.name;
        this.email = otherStudent.email;
        this.gpa = otherStudent.gpa;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        if (0 <= gpa && gpa <= 4) {
            this.gpa = gpa;
        } else {
            System.out.println("[LOI] Khong the thay doi diem GPA khong hop le!");
        }
    }

    public void printInfo() {
        System.out.println("Thong tin: Ten:" + name + ", ID: " + id + ", email: " + email + ", GPA: " + gpa);
    }

    public static void main(String[] args) {
        System.out.println("Hoc Sinh Thu Nhat");
        Student Student1 = new Student();
        Student1.setID("1001");
        Student1.setName("Nguyen Van A");
        Student1.setEmail("avn@gmail.com");
        Student1.setGPA(3.67);
        Student1.printInfo();

        System.out.println("Hoc Sinh Thu Hai");
        Student Student2 = new Student("1002", "Nguyen Van B");
        Student2.setEmail("bvn@gmail.com");
        Student2.setGPA(3.88);
        Student2.printInfo();

        System.out.println("Hoc Sinh Thu Ba");
        Student Student3 = new Student("1003", "Nguyen Van C", "cvn@gmail.com", 3.47);
        Student3.setGPA(-3.67);
        Student3.printInfo();
    }
}