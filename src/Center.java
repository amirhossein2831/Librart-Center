import java.util.HashMap;

public class Center {
    private HashMap<String, Library> libraries;
    private HashMap<String, Category> categories;
    private HashMap<String, Student> students;


    public Center() {
        libraries = new HashMap<>();
        categories = new HashMap<>();
        students = new HashMap<>();
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
        if (library.getBook(book.getId()) != null) {
            return "duplicate-id";
        }
        library.addBook(book);
        return "success";
    }

    public String editBook(Book book) {
        Library library = libraries.get(book.getLibraryId());
        if (library == null) {
            return "not-found";
        }
        Category category = categories.get(book.getCategoryId());
        if (category == null) {
            return "not-found";
        }
        Book book1 = library.getBook(book.getId());
        if (book1 == null) {
            return "not-found";
        }
        book1.edit(book);
        return "success";
    }

    public String addThesis(Thesis thesis) {
        Library library = libraries.get(thesis.getLibraryId());
        if (library == null) {
            return "not-found";
        }
        Category category = categories.get(thesis.getCategoryId());
        if (category == null) {
            return "not-found";
        }
        if (library.getThesis(thesis.getId()) != null) {
            return "duplicate-id";
        }
        library.addThesis(thesis);
        return "success";
    }

    public String editThesis(Thesis thesis) {
        Library library = libraries.get(thesis.getLibraryId());
        if (library == null) {
            return "not-found";
        }
        Category category = categories.get(thesis.getCategoryId());
        if (category == null) {
            return "not-found";
        }
        Thesis thesis1 = library.getThesis(thesis.getId());
        if (thesis1 == null) {
            return "not-found";
        }
        thesis1.edit(thesis);
        return "success";
    }

    //TODO:
    //this method need another condition to say not-allowed
    public String  removeBook(String bookId, String libraryId) {
        Library library = libraries.get(libraryId);
        if (library == null) {
            return "not-found";
        }
        if (library.getBook(bookId) == null) {
            return "not-found";
        }
        library.removeBook(bookId);
        return "success";
    }

    public String removeThesis(String thesisId, String libraryId) {
        Library library = libraries.get(libraryId);
        if (library == null) {
            return "not-found";
        }
        if (library.getThesis(thesisId) == null) {
            return "not-found";
        }
        library.removeThesis(libraryId);
        return "success";
    }

    public String addStudent(Student student) {
        if (students.get(student.getId()) != null) {
            return "duplicate-id";
        }
        students.put(student.getId(), student);
        return "success";
    }

    public String editStudent(Student student) {
        Student student1 = students.get(student.getId());
        if (student1 == null) {
            return "not-found";
        }
        student1.edit(student);
        return "success";
    }
}
