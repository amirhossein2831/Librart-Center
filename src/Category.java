import java.util.HashSet;

public class Category {
    private String id;
    private String name;

    private HashSet<String> bookId;
    private HashSet<String> thesisId;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
        bookId = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getBookId() {
        return bookId;
    }

    public HashSet<String> getThesisId() {
        return thesisId;
    }

    public void addBookId(String bookId) {
        this.bookId.add(bookId);
    }

    public void addThesisId(String thesisId) {
        this.thesisId.add(thesisId);
    }
}
