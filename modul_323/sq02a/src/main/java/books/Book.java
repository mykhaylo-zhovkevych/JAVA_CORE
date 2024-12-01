package books;

public class Book {
    private String title;
    private String author;
    private int releaseYear;
    private int soldCopies;

    public Book(String title, String author, int releaseYear, int soldCopies) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.soldCopies = soldCopies;
    }

    // Getter-Methoden
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getSoldCopies() {
        return soldCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", soldCopies=" + soldCopies +
                '}';
    }
}
