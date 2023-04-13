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

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setNumBook(int numBook) {
        this.numBook = numBook;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public void edit(Book book) {
        if (!book.getName().equals("-")) {
           setName(book.getName());
        }
        if (!book.getAuthorName().equals("-")) {
            setAuthorName(book.getAuthorName());
        }
        if (!book.getPublisher().equals("-")) {
            setPublisher(book.getPublisher());
        }
        if (!book.getYear().equals("-")) {
            setYear(book.getYear());
        }
        if (book.getNumBook() != -1) {
            setNumBook(book.getNumBook());
        }
        if (book.getCategoryId().equals("-")) {
            setCategoryId(book.getCategoryId());
        }
    }
}
