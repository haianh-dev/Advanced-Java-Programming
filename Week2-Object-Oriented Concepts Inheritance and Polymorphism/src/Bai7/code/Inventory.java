package Bai7.code;

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printInfo() {
        System.out.println("- " + name + " (ID: " + id + "): $" + price);
    }
}

public class Inventory {
    public Product[] items;

    public Inventory(Product[] initiallitems) {
        this.items = initiallitems;
    }

    public void Inventory() {
        for (Product p : items) {
            p.printInfo();
        }
    }

    public static void main(String[] args) {
        Product Laptop = new Product("1000", "Laptop", 1000);
        Product Mouse = new Product("1001", "Mouse", 100);

        Product[] arr = new Product[2];
        arr[0] = Laptop;
        arr[1] = Mouse;

        Inventory kho = new Inventory(arr);

        System.out.println("Danh sach san pham trong kho truoc khi doi gia: ");
        kho.Inventory();
        
        changePrice(arr, kho);
    }

    public static void changePrice(Product[] arr, Inventory kho) {
        arr[0].setPrice(5000);

        System.out.println("Danh sach san pham trong kho sau khi doi gia: ");
        kho.Inventory();
    }
}
