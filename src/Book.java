public class Book {
    private String id;
    private String name;
    private String authorName;
    private String publisher;
    private String year;
    private int numBook;
    private String categoryId;
    private String libraryId;

    public Book(String id, String name, String authorName, String publisher, String year, int numBook, String categoryId, String libraryId) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.publisher = publisher;
        this.year = year;
        this.numBook = numBook;
        this.categoryId = categoryId;
        this.libraryId = libraryId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getYear() {
        return year;
    }

    public int getNumBook() {
        return numBook;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getLibraryId() {
        return libraryId;
    }
}
