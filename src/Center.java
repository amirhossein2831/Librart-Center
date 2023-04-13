import java.util.ArrayList;
import java.util.HashMap;

public class Center {
    private HashMap<String, Library> libraries;
    private HashMap<String, Category> categories;
    private HashMap<String, Book> books; public Book() {
    }

    public Center() {
        libraries = new HashMap<>();
        categories = new HashMap<>();
        books = new HashMap<>();
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
        if (books.get(book.getId()) != null) {
            return "duplicate-id";
        }
        books.put(book.getId(), book);
        return "success";
    }
}
