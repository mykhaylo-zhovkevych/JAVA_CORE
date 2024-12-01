package books;

import java.util.ArrayList;
import java.util.List;

public class Library {

	// The method does not require any parameters to be called, which means it is parameterless
    public static List<Book> getBooks() {
    	
        List<Book> books = new ArrayList<>();

        books.add(new Book("Herr der Ringe", "J.R.R. Tolkien", 1954, 1000000));
        books.add(new Book("Der Hobbit", "J.R.R. Tolkien", 1937, 500000));
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997, 12000000));
        books.add(new Book("Per Anhalter durch die Galaxis", "Douglas Adams", 1979, 5000000));
        books.add(new Book("Die Entdeckung der Langsamkeit", "Sten Nadolny", 1983, 200000));

        books.add(new Book("Neuromancer", "William Gibson", 1984, 3000000));
        books.add(new Book("Dune", "Frank Herbert", 1965, 4000000));

        return books;
    }
}
