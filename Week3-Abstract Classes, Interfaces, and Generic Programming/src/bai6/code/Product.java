package bai6.code;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Electronics extends Product {
    double warranty;

    public Electronics(String name, double price, double warranty) {
        super(name, price);
        this.warranty = warranty;
    }

    public double getFinalPrice() {
        return 1.1 * price + warranty;
    }

    public void getInfo() {
        System.out.println(name + " - Electronics - " + getFinalPrice());
    }
}

class Food extends Product {
    LocalDate expiryDate;

    public Food(String name, double price, LocalDate expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public double getFinalPrice() {
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(today, expiryDate);
        if (daysBetween > 0 && daysBetween < 7) {
            return 0.8 * price;
        } else {
            return price;
        }
    }

    public void getInfo() {
        System.out.println(name + " - Food - " + getFinalPrice());
    }
}

public abstract class Product {
    String id;
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract double getFinalPrice();
    public abstract void getInfo();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong san pham: ");
        int quantity = sc.nextInt();
        Product[] productlist = new Product[quantity];

        for (int i = 0; i < quantity; i++) {
            System.out.println("Nhap kieu san pham: ");
            String typeProduct = sc.next();
            sc.nextLine();
            System.out.println("Nhap ten san pham: ");
            String name = sc.next();
            sc.nextLine();

            if (typeProduct.equals("E")) {
                System.out.println("Nhap gia goc san pham: ");
                double price = sc.nextDouble();
                System.out.println("Nhap phi bao hanh: ");
                double warranty = sc.nextDouble();
                productlist[i] = new Electronics(name, price, warranty);
            } else if (typeProduct.equals("F")) {
                System.out.println("Nhap gia goc san pham: ");
                double price = sc.nextDouble();
                System.out.println("Nhap ngay het han: ");
                String dateString = sc.next();
                LocalDate expiryDate = LocalDate.parse(dateString);
                productlist[i] = new Food(name, price, expiryDate);
            }
        }

        for (Product product : productlist) {
            product.getInfo();
        }

        long total = 0;
        for (Product product : productlist) {
            total = (long) (total + product.getFinalPrice());
        }
        System.out.println("Total = " + total);
    }
}
