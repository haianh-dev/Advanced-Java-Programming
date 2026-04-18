package bai5.code.arraylist.code;

import java.util.ArrayList;
import java.util.List;

class Book {
    String id;
    String Title;
    String Author;
    int Year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.Title = title;
        this.Author = author;
        this.Year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        System.out.println("- Dang bat dau them sach vao trinh quan ly thu vien.");
        books.add(new Book("B1", "Dac Nhan Tam", "Dale Carnegie", 1936));
        books.add(new Book("B2","Nha Gia Kim", "Paulo Coelho", 1988));
        books.add(new Book("B3", "Tuoi Tre Dang Gia Bao Nhieu?", "Rosie Nguyen", 2016));
        books.add(new Book("B4", "Nguoi Giau Co Nhat Thanh Babylon", "George S. Clason", 1926));
        books.add(new Book("B5", "Khong Gia Dinh", "Hector Malot", 1878));
        System.out.println("- Da hoan tat qua trinh them sach vao thu vien!");

        String targetBookID1 = "B3";
        System.out.println("- Xu ly yeu cau tim sach co ID: " + targetBookID1);
        for (Book book : books) {
            if (book.id.equals(targetBookID1)) {
                System.out.println("Da tim thay sach: " + book.Title);
            }
        }

        String targetBookID2 = "B1";
        System.out.println("- Xu ly yeu cau xoa sach ID: " + targetBookID2);
        for (Book book : books) {
            if (book.id.equals(targetBookID2)) {
                books.remove(book);
                System.out.println("Da xoa sach: " + book.Title);
                break;
            }
        }

        System.out.println("- In thong tin tat ca sach trong trinh quan ly thu vien:");
        for (Book book : books) {
            System.out.println("ID: " + book.id + ", Title: " +
                    book.Title + ", Author: " + book.Author + ", Year: " + book.Year);
        }
    }
}
