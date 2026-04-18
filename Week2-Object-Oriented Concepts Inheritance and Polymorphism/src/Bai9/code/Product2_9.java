package Bai9.code;

import java.util.Scanner;
public class Product2_9 {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0.0;

    public Product2_9(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate(double newRate) {
        Product2_9.taxRate = newRate;
    }

    public double calculateFinalPrice() {
        double finalPrice = (price - discount) * (1 + taxRate);
        return finalPrice;
    }

    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= quantity) {
            this.quantity -= amount;
            double v = amount * calculateFinalPrice();
            Product2_9.totalRevenue += v;
            System.out.println("Tinh thanh cong tong doanh thu! Tong doanh thu la: " + totalRevenue);
        } else {
            System.err.println("[Loi] Khong du hang trong kho!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap thong tin san pham I:");
        System.out.println("Nhap ten san pham I:");
        String name1 = sc.nextLine();
        System.out.println("Nhap gia san pham I:");
        double price1 = sc.nextDouble();
        System.out.println("Nhap so luong hang ton kho cua san pham I:");
        int quantity1 = sc.nextInt();
        System.out.println("Nhap muc giam gia cua san pham I:");
        double discount1 = sc.nextDouble();
        Product2_9 p1 = new Product2_9(name1, price1, quantity1, discount1);
        sc.nextLine();

        System.out.println("Nhap thong tin san pham II:");
        System.out.println("Nhap ten san pham II:");
        String name2 = sc.nextLine();
        System.out.println("Nhap gia san pham II:");
        double price2 = sc.nextDouble();
        System.out.println("Nhap so luong hang ton kho cua san pham II:");
        int quantity2 = sc.nextInt();
        System.out.println("Nhap muc giam gia cua san pham II:");
        double discount2 = sc.nextDouble();
        Product2_9 p2 = new Product2_9(name2, price2, quantity2, discount2);
        sc.nextLine();

        System.out.println("\nNhap so luong can mua cho san pham I: ");
        p1.sell(sc.nextInt());
        sc.nextLine();

        System.out.println("Nhap so luong can mua cho san pham II: ");
        p2.sell(sc.nextInt());
        sc.nextLine();

        System.out.println("Tong doanh thu toan he thong la: " + Product2_9.totalRevenue);

        System.out.println("\nGia cuoi cung cua san pham I la: " + p1.calculateFinalPrice());
        System.out.println("Gia cuoi cung cua san pham II la: " + p2.calculateFinalPrice());

        Product2_9.updateTaxRate(0.08);

        System.out.println("\nGia cuoi cung cua san pham I sau khi updateTaxRate la: " + p1.calculateFinalPrice());
        System.out.println("Gia cuoi cung cua san pham II sau khi updateTaxRate la: " + p2.calculateFinalPrice());

        p1.updateDiscount(10.0);
        System.out.println("\nGia cuoi cung cua san pham I sau khi updateNewDiscount la: " + p1.calculateFinalPrice());
        System.out.println("Gia cuoi cung cua san pham II la: " + p2.calculateFinalPrice());

        System.out.println("Tong doanh thu toan he thong la: " + Product2_9.totalRevenue);

        sc.close();
    }
}