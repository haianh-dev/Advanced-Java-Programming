package bai9.code;
import java.util.Scanner;

interface IPayable {
    double getPaymentAmount();
}

abstract class Staff implements IPayable {
    String id;
    String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class PartTimeStaff extends Staff {
    int workingHours;
    double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }

    public void getInfo() {
        System.out.println("PartTimeStaff " + name + " - Payment: " + getPaymentAmount());
    }
}

class Invoice implements IPayable {
    String itemName;
    int quantity;
    double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    public void getInfo() {
        System.out.println("Invoice " + itemName + " - Payment: " + getPaymentAmount());
    }
}

public class Main {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong doi tuong can thanh toan: ");
        int getPayableCount = sc.nextInt();
        IPayable[] payableList = new IPayable[getPayableCount];

        for (int i = 0; i < getPayableCount; i++) {
            System.out.println("Nhap loai doi tuong can thanh toan: ");
            String payableObject = sc.next();

            if (payableObject.equals("S")) {
                System.out.println("Nhap ID nhan vien: ");
                String id = sc.next();
                System.out.println("Nhap ten nhan vien: ");
                String name = sc.next();
                System.out.println("Nhap thoi gian lam viec cua nhan vien: ");
                int workingHours = sc.nextInt();
                System.out.println("Nhap muc luong theo gio cua nhan vien: ");
                double hourlyRate = sc.nextDouble();
                sc.nextLine();
                payableList[i] = new PartTimeStaff(id, name, workingHours, hourlyRate);
            } else if (payableObject.equals("I")) {
                System.out.println("Nhap ten san pham: ");
                String itemName = sc.next();
                System.out.println("Nhap so luong san pham: ");
                int quantity = sc.nextInt();
                System.out.println("Nhap gia moi san pham: ");
                double pricePerItem = sc.nextDouble();
                sc.nextLine();
                payableList[i] = new Invoice(itemName, quantity, pricePerItem);
            }
        }
        System.out.println();

        double total = 0;
        for (IPayable payable: payableList) {
            if (payable instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) payable;
                staff.getInfo();
                total = total + staff.getPaymentAmount();
            } else if (payable instanceof Invoice) {
                Invoice invoice = (Invoice) payable;
                invoice.getInfo();
                total = total + invoice.getPaymentAmount();
            }
        }
        System.out.println("Total Payment = " + total);
    }
}
