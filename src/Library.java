import java.util.Date;
import java.util.HashMap;

public class Library {
    private String id;
    private String name;
    private String year;
    private int numSeat;
    private String address;
    private HashMap<String, Book> books;
    private HashMap<String, Thesis> theses;
    public Library(String id, String name, String year, int numSeat, String address) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.numSeat = numSeat;
        this.address = address;
        books = new HashMap<>();
        theses = new HashMap<>();
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

    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    public void addBook(Book book) {
        this.books.put(book.getId(), book);
    }

    public Thesis getThesis(String thesisId) {
        return theses.get(thesisId);
    }
    public void addThesis(Thesis thesis) {
        this.theses.put(thesis.getId(), thesis);
    }

    public void removeBook(String id) {
        books.remove(id);
    }

    public void removeThesis(String id) {
        theses.remove(id);
    }
}
