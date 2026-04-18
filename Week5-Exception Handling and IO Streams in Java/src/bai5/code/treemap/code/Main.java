package bai5.code.treemap.code;

import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<String, Book> books = new TreeMap<>();

        System.out.println("- Dang bat dau them sach vao trinh quan ly thu vien.");
        books.put("B1", new Book("B1", "Dac Nhan Tam", "Dale Carnegie", 1936));
        books.put("B2", new Book("B2", "Nha Gia Kim", "Paulo Coelho", 1988));
        books.put("B3", new Book("B3", "Tuoi Tre Dang Gia Bao Nhieu?", "Rosie Nguyen", 2016));
        books.put("B4", new Book("B4", "Nguoi Giau Co Nhat Thanh Babylon", "George S. Clason", 1926));
        books.put("B5", new Book("B5", "Khong Gia Dinh", "Hector Malot", 1878));
        System.out.println("- Da hoan tat qua trinh them sach vao thu vien!");

        String targetBookID1 = "B3";
        System.out.println("- Xu ly yeu cau tim sach co ID: " + targetBookID1);
        if (books.containsKey(targetBookID1)) {
            Book targetBook = books.get(targetBookID1);
            System.out.println("Da tim thay sach: " + targetBook.Title);
        } else {
            System.out.println("Khong tim thay sach!");
        }

        String targetBookID2 = "B1";
        System.out.println("- Xu ly yeu cau xoa sach ID: " + targetBookID2);
        if (books.containsKey(targetBookID2)) {
            Book targetBook = books.get(targetBookID2);
            books.remove(targetBookID2);
            System.out.println("Da xoa sach: " + targetBook.Title);
        } else {
            System.out.println("Khong tim thay sach!");
        }

        System.out.println("- In thong tin tat ca sach trong trinh quan ly thu vien:");
        for (Map.Entry<String, Book> map: books.entrySet()) {
            System.out.println("ID: " + map.getValue().id + ", Title: " +
                    map.getValue().Title + ", Author: " + map.getValue().Author + ", Year: " + map.getValue().Year);
        }
    }
}
