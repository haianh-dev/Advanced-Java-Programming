package bai9.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void printDetails();
}

class Food extends Product {
    protected String expiryDate;
    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void printDetails() {
        System.out.println(name + " - " + expiryDate);
    }
}

class Electronic extends Product {
    protected int warrantyMonths;
    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void printDetails() {
        System.out.println(name + " - " + warrantyMonths + " thang bao hanh");
    }
}

class wareHouse<T extends Product> {
    private List<T> products;

    public wareHouse() {
        this.products = new ArrayList<>();
    }

    public void receiveProduct(T product) {
        this.products.add(product);
    }

    public void issueProduct(T product) {
        this.products.remove(product);
    }
    public void auditStock() {
        for (T product : products) {
            product.printDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so luong hang hoa: ");
        int n = input.nextInt();
        wareHouse<Food> foodWarehouse = new wareHouse<>();
        wareHouse<Electronic> electronicWarehouse = new wareHouse<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap loai, ma id, ten hang hoa: ");
            String type = input.next();
            String id = input.next();
            String name = input.next();

            if (type.equals("F")) {
                System.out.println("Nhap ngay het han su dung: ");
                String expiryDate = input.next();
                foodWarehouse.receiveProduct(new Food(id, name, expiryDate));
            } else if (type.equals("E")) {
                System.out.println("Nhap so thang bao hanh: ");
                String warrantyMonths = input.next();
                electronicWarehouse.receiveProduct(new Electronic(id, name, Integer.parseInt(warrantyMonths)));
            }
        }

        System.out.println("Kho Thuc pham: ");
        foodWarehouse.auditStock();
        System.out.println();
        System.out.println("Kho Dien tu:");
        electronicWarehouse.auditStock();
    }
}
