import java.util.Date;
import java.util.HashMap;

public class Library {
    private String id;
    private String name;
    private String year;
    private int numSeat;
    private String address;
    private HashMap<String, Book> books;
    public Library(String id, String name, String year, int numSeat, String address) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.numSeat = numSeat;
        this.address = address;
        books = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public int getNumSeat() {
        return numSeat;
    }

    public String getAddress() {
        return address;
    }

    public Book getbook(String bookId) {
        return books.get(bookId);
    }

    public void addBook(Book book) {
        this.books.put(book.getId(), book);
    }
}
