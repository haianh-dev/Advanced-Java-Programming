package bai10.code;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class MediaItem {
    protected String id;
    protected String name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void printDetails();
}

class Book extends MediaItem {
    protected String author;
    protected int pages;

    public Book(String id, String name,String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public void printDetails() {
        System.out.println(name + " - " + author + " - " + pages);
    }
}

class DVD extends MediaItem {
    protected String director;
    protected int duration;

    public DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void printDetails() {
        System.out.println(name + " - " + director + " - " + duration);
    }
}

class LibrarySection<T extends MediaItem> {
    private List<T> items;

    public LibrarySection() {
        this.items = new ArrayList<>();
    }

    public void addDocument(T item) {
        this.items.add(item);
    }

    public void removeDocument(T item) {
        this.items.remove(item);
    }

    public void displayDocuments() {
        for (T item : this.items) {
            item.printDetails();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong tai lieu: ");
        int n = sc.nextInt();
        LibrarySection<Book> bookLibrarySection = new LibrarySection<>();
        LibrarySection<DVD> DVDLibrarySection = new LibrarySection<>();

        for  (int i = 0; i < n; i++) {
            System.out.println("Nhap loai, ma ID, ten tai lieu: ");
            String type = sc.next();
            String id  = sc.next();
            String name = sc.next();

            if (type.equals("B")) {
                System.out.println("Nhap tac gia, so trang cua sach: ");
                String author = sc.next();
                int pages = sc.nextInt();
                bookLibrarySection.addDocument(new Book(id,name,author,pages));
            } else if (type.equals("D")) {
                System.out.println("Nhap dao dien, thoi luong cua DVD: ");
                String director = sc.next();
                int duration = sc.nextInt();
                DVDLibrarySection.addDocument(new DVD(id,name,director,duration));
            }
        }

        System.out.println("Khu vuc Sach: ");
        bookLibrarySection.displayDocuments();
        System.out.println();
        System.out.println("Khu vuc DVD: ");
        DVDLibrarySection.displayDocuments();
    }
}
