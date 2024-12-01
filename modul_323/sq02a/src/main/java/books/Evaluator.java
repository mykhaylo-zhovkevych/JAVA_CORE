package books;

import java.util.List;
import java.util.Optional;

public class Evaluator {

	
//	1. Gib die Anzahl aller Bücher aus.
//	2. Gib die Anzahl aller Bücher aus, welche nach dem Jahr 2000 veröffentlicht wurden.
//	3. Gib an, wie viele Bücher insgesamt verkauft wurden.
//	4. Gib an, wie viele Bücher im Durchschnitt verkauft wurden.
//	5. Gib an, welches Buch am wenigsten Verkäufe hat, inklusive Zahl.
//	6. Gib an, welches Buch am meisten Verkäufe hat, inklusive Zahl.
//	7. Gib an, wie viele Bücher en bestimmter Autor insgesamt verkauft hat.
//	8. Gib an, wie viele Kopien der Bücher, welche zwischen den Jahren 1990 & 2000 veröffentlicht wurden, abgesetzt wurden.
//	9. Gib an, welches Buch das älteste ist und wann es veröffentlicht wurde.
//	10. Gib an, in welchem Jahr zuletzt ein Buch veröffentlicht wurde.
	
public static void main(String[] args) {
	
	List<Book> books = Library.getBooks();		
		
		//	1. Gib die Anzahl aller Bücher aus.
		System.out.println("Anzahl aller Bücher: " + books.size());
	
		//	2. Gib die Anzahl aller Bücher aus, welche nach dem Jahr 1980 veröffentlicht wurden.
		
		long booksAfter1980 = books.stream()
								    .filter(book -> book.getReleaseYear() > 1980)
									.count();
		System.out.println(booksAfter1980);
		
		
		//	3. Gib an, wie viele Bücher insgesamt verkauft wurden.
		
		// Die map-Methode wird verwendet, um Elemente in einem Stream von einem Typ in einen anderen Typ zu transformieren. Sie erstellt aus einem Stream ein neues Element für jeden Eintrag im ursprünglichen Stream
		int totalSoldCopies = books.stream()	// Das ist eine Methodenreferenz, die auf die Methode getSoldCopies() der Klasse Book verweist, Statt eine Lambda-Expression wie book -> book.getSoldCopies() zu schreiben, gibt es Kurzform Book::getSoldCopies 
									.mapToInt(Book::getSoldCopies)
									.sum();
		System.out.println("Gesamtzahl der verkauften Bücher: " + totalSoldCopies);
		
		
		// 4. Gib an, wie viele Bücher im Durchschnitt verkauft wurden.
		
		double avgSoldCopies = books.stream()
									.mapToInt(Book::getSoldCopies)
									.average()
									.orElse(0);
		System.out.println(avgSoldCopies);
		
		//	5. Gib an, welches Buch am wenigsten Verkäufe hat, inklusive Zahl.
		
		Optional<Book> leastSoldBook = books.stream()
											.min((b1, b2) -> Integer.compare(b1.getSoldCopies(), b2.getSoldCopies()));
	
		leastSoldBook.ifPresent(book -> System.out.println("Buch mit den wenigsten Verkäufen: " + book.getTitle() + " (" + book.getSoldCopies() + " verkaufte Exemplare)"));
		
		 
		 //		6. Gib an, welches Buch am meisten Verkäufe hat, inklusive Zahl.
		 
		Optional<Book> mostSoldBook = books.stream()
	                						.max((b1, b2) -> Integer.compare(b1.getSoldCopies(), b2.getSoldCopies()));
	    mostSoldBook.ifPresent(book -> System.out.println("Buch mit den meisten Verkäufen: " + book.getTitle() + " (" + book.getSoldCopies() + " verkaufte Exemplare)"));

		 
	    //	7. Gib an, wie viele Bücher en bestimmter Autor insgesamt verkauft hat.
		 
	    String author = "J.R.R. Tolkien";
	    int soldByAuthor = books.stream()
	    						.filter(book -> book.getAuthor().equals(author))
	    						.mapToInt(Book::getSoldCopies)
	    						.sum();
	    System.out.println("Verkäufe von " + author + ": " + soldByAuthor);
	    
	    //	8. Gib an, wie viele Kopien der Bücher, welche zwischen den Jahren 1990 & 2000 veröffentlicht wurden, abgesetzt wurden.
	    
	    int soldBetween1990And2000 = books.stream()
	    							  	 .filter(book -> book.getReleaseYear() >= 1990 && book.getReleaseYear() <= 2000)
	    							  	 .mapToInt(Book::getSoldCopies)
	    							  	 .sum();
	    System.out.println("Verkäufe der Bücher zwischen 1990 und 2000: " + soldBetween1990And2000);

	    
	    // 9. Gib an, welches Buch das älteste ist und wann es veröffentlicht wurde.
	    
	    Optional<Book> oldestBook = books.stream()
                .min((b1, b2) -> Integer.compare(b1.getReleaseYear(), b2.getReleaseYear()));
        oldestBook.ifPresent(book -> System.out.println("Ältestes Buch: " + book.getTitle() + " (Veröffentlicht: " + book.getReleaseYear() + ")"));

        // 10. Jahr der letzten Veröffentlichung
        
        Optional<Book> latestBook = books.stream()
                .max((b1, b2) -> Integer.compare(b1.getReleaseYear(), b2.getReleaseYear()));
        latestBook.ifPresent(book -> System.out.println("Letztes veröffentlichtes Buch: " + book.getTitle() + " (Veröffentlicht: " + book.getReleaseYear() + ")"));
	    
	    
	}
}
