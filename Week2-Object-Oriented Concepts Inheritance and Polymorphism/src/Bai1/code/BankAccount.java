package Bai1.code;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            this.balance = 0;
            System.out.println("Loi! So du tai khoan khong the nho hon 0!");
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Nap thanh cong so tien: " + amount);
        } else {
            System.out.println("Loi! So tien nap vao phai lon hon 0!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("Rut thanh cong so tien: " + amount);
            return true;
        } else {
            System.out.println("Loi! Rut khong thanh cong!");
            return false;
        }
    }

    public double getBalance() {
        return this.balance;
    }


    public static void main(String[] args) {
        BankAccount MyAccount = new BankAccount("0348896894", "NguyenHaiAnh", 0.0);

        System.out.println("Trang Thai Ban Dau");
        System.out.println("So du hien tai: " + MyAccount.getBalance());

        System.out.println("Test 1: Nap tien am");
        MyAccount.deposit(-500);
        System.out.println("So du hien tai: " + MyAccount.getBalance());

        System.out.println("Test 2: Nap tien duong");
        MyAccount.deposit(1000);
        System.out.println("So du hien tai: " + MyAccount.getBalance());

        System.out.println("Test 3: Rut qua so du");
        MyAccount.withdraw(2000);
        System.out.println("So du hien tai: " + MyAccount.getBalance());

        System.out.println("Test 4: Rut khong qua so du");
        MyAccount.withdraw(500);
        System.out.println("So du hien tai: " + MyAccount.getBalance());

        System.out.println("Test 5: Rut tien khong hop le");
        MyAccount.withdraw(-500);
        System.out.println("So du hien tai: " + MyAccount.getBalance());
    }
}