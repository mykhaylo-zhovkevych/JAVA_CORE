package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class sq01c {
    public static void main(String[] args) {
        // 1.-3. Creating and adding books to the list
        List<Book> books = new ArrayList<>();
        books.add(new Book("J.R.R. Tolkien", "Herr Der Ringe", 450));
        books.add(new Book("J.R.R. Tolkien", "Herr Der Ringe - Die zwei Türme", 450));
        books.add(new Book("Adam Douglas", "Per Anhalter durch die Galaxy", 250));
        books.add(new Book("H. Buff", "Datenbanktheorie", 350));
        books.add(new Book("J.K. Rowling", "Harry Potter", 350));

        // 4.a - Using BookPrinter as a Consumer
        Consumer<Book> printer = new BookPrinter();
        books.forEach(printer);

        // 4.b - Using an anonymous class
        books.forEach(new Consumer<Book>() {
            @Override
            public void accept(Book t) {
                System.out.println(t.getTitle());
            }
        });

        // 4.c - Using a lambda expression
        Consumer<Book> print = book -> System.out.println(book.getTitle());
        books.forEach(print);

        
        // 4.d - Using another lambda with detailed info
		//        books.forEach(book -> {
		//            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getPages());
		//        });
        
        books.forEach(System.out::println);
        
        books.forEach(b -> System.out.print(b));
        
        
        
    }

    // Inner Class Book
    public static class Book {
        private String author;
        private String title;
        private int pages;

        public Book(String author, String title, int pages) {
            this.author = author;
            this.title = title;
            this.pages = pages;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
    }

    public static class BookPrinter implements Consumer<Book> {
        @Override
        public void accept(Book book) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages");
        }
    }
}
