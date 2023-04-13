import java.util.HashMap;

public class Center {
    private HashMap<String, Library> libraries;
    private HashMap<String, Category> categories;
    private HashMap<String, Book> books;


    public Center() {
        libraries = new HashMap<>();
        categories = new HashMap<>();
        books = new HashMap<>();
        categories.put("null", new Category("null", "null"));

    }

    public String addLibrary(Library library) {
        if (libraries.get(library.getId()) != null) {
            return "duplicate-id";
        }
        libraries.put(library.getId(), library);
        return "success";
    }

    public String addCategory(Category category) {
        if (categories.get(category.getId()) != null) {
            return "duplicate-id";
        }
        categories.put(category.getId(), category);
        return "success";
    }

    public String addBook(Book book) {
        Library library = libraries.get(book.getLibraryId());
        if (library == null) {
            return "not-found";
        }
        Category category = categories.get(book.getCategoryId());
        if (category == null) {
            return "not-found";
        }
        if (library.getbook(book.getId()) != null) {
            return "duplicate-id";
        }
        library.addBook(book);
        category.addBookId(book.getCategoryId());
        return "success";
    }
}
