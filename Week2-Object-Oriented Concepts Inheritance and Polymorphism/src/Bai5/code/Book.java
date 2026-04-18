package Bai5.code;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book otherBook = (Book) obj;

        return Objects.equals(this.author, otherBook.author) &&
                Objects.equals(this.title, otherBook.title) &&
                this.price == otherBook.price;
    }

    public static void main(String[] args) {
        Book Book1 = new Book("Xac Suat Thong Ke", "Do Van Duc", 300);
        Book Book2 = new Book("Xac Suat Thong Ke", "Do Van Duc", 300);

        System.out.println("So sanh bang '=='");
        boolean ss1 = Book1 == Book2;
        System.out.println("Ket qua so sanh bang '==': " + ss1);

        System.out.println("So sanh bang 'equals'");
        boolean ss2 = Book1.equals(Book2);
        System.out.println("Ket qua so sanh bang 'equals': " + ss2);
    }
}

/* == và equals khác nhau như thế nào?
- Toán tử '==' (So sánh tham chiếu/địa chỉ ô nhớ):
+ Định nghĩa: Chỉ trả về true khi cả hai biến cùng trỏ đến đúng một đối tượng duy nhất trong bộ nhớ vật lý.
+ Cách dùng: Thường được sử dụng để so sánh các kiểu dữ liệu nguyên thủy (int, double, boolean...).
- Phương thức ".equals()" (So sánh nội dung / giá trị):
+ Định nghĩa: Trả về true khi nội dung (dữ liệu) bên trong của hai đối tượng hoàn toàn giống nhau, cho dù chúng được lưu ở hai ô nhớ khác nhau (với điều kiện hàm này đã được ghi đè - Override).
+ Cách dùng: Luôn được sử dụng để so sánh các Chuỗi (String) hoặc các Đối tượng (Object như Book, Student...).
*/