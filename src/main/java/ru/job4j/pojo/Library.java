package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("War and peace", 2000);
        Book book3 = new Book("Crime and punishment", 500);
        Book book4 = new Book("The old man and the sea", 1000);
        Book[] book = new Book[4];
        book[0] = book1;
        book[1] = book2;
        book[2] = book3;
        book[3] = book4;
        for (Book bk: book) {
            System.out.println("In the book " + bk.getName() + " " + bk.getCount() + " pages");
        }
        System.out.println();
        Book temp = book[0];
        book[0] = book[3];
        book[3] = temp;
        for (Book bk: book) {
            System.out.println("In the book " + bk.getName() + " " + bk.getCount() + " pages");
        }
        System.out.println();
        for (Book bk: book) {
            if ("Clean code".equals(bk.getName())) {
                System.out.println("In the book " + bk.getName() + " " + bk.getCount() + " pages");
            }
        }
    }
}
