import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Center {
    private final HashMap<String, Library> libraries;
    private final HashMap<String, Category> categories;
    private final HashMap<String, Student> students;
    private final HashMap<String, Staff> staffs;


    public Center() {
        libraries = new HashMap<>();
        categories = new HashMap<>();
        students = new HashMap<>();
        staffs = new HashMap<>();
        categories.put("null", new Category("null", "null"));
    }

    public Library getLibrary(String libraryId) {
        return libraries.get(libraryId);
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
    public String removeBook(String bookId, String libraryId) {
        Library library = libraries.get(libraryId);
        if (library == null) {
            return "not-found";
        }
        if (library.countStuffs(bookId) != 0) {
            return "not-allowed";
        }
        if (library.getBook(bookId) == null) {
            return "not-found";
        }
        library.removeBook(bookId);
        return "success";
    }

    //TODO:
    //this method need another condition to say not-allowed
    public String removeThesis(String thesisId, String libraryId) {
        Library library = libraries.get(libraryId);
        if (library == null) {
            return "not-found";
        }
        if (library.countStuffs(thesisId) != 0) {
            return "not-allowed";
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

    //TODO:
    //this method need another condition to say not-allowed
    public String removeStudent(String id) {
        Student student = students.get(id);
        if (student == null) {
            return "not-found";
        }
        for (Library library : new ArrayList<>(libraries.values())) {
            if (library.checkUserBorrows(id) != null) {
                return "not-allowed";
            }
        }
        if (student.getDebt() != 0) {
            return "not-allowed";
        }
        students.remove(id);
        return "success";
    }

    public String addStaff(Staff staff) {
        if (staffs.get(staff.getId()) != null) {
            return "duplicate-id";
        }
        staffs.put(staff.getId(), staff);
        return "success";
    }

    public String editStaff(Staff staff) {
        Staff staff1 = staffs.get(staff.getId());
        if (staff1 == null) {
            return "not-found";
        }
        staff1.edit(staff);
        return "success";
    }

    //TODO:
    //this method need another condition to say not-allowed
    public String removeStaff(String id) {
        Staff staff = staffs.get(id);
        if (staff ==  null) {
            return "not-found";
        }
        if (staff.getDebt() != 0) {
            return "not-allowed";
        }
        for (Library library : new ArrayList<>(libraries.values())) {
            if (library.checkUserBorrows(id) != null) {
                return "not-allowed";
            }
        }
        staffs.remove(id);
        return "success";
    }

    public String borrow(Borrow borrow, String pass) {
        if (!borrow.evaluateIsStudent(new HashSet<>(students.keySet()), new HashSet<>(staffs.keySet()))) {
            return "not-found";
        }
        if (borrow.isStudent()) {
            Student student = students.get(borrow.getUserId());
            if (!student.getPass().equals(pass)) {
                return "invalid-pass";
            }
        } else {
            Staff staff = staffs.get(borrow.getUserId());
            if (!staff.getPass().equals(pass)) {
                return "invalid-pass";
            }
        }
        Library library = libraries.get(borrow.getLibraryId());
        if (library == null) {
            return "not-found";
        }
        if (!borrow.evaluateIsBook(library.getBookIds(), library.getThesisIds())) {
            return "not-found";
        }
        if (!library.borrow(borrow)) {
            return "not-allowed";
        }
        return "success";
    }

    public String returning(Borrow borrow, String pass) {
        if (!borrow.evaluateIsStudent(new HashSet<>(students.keySet()), new HashSet<>(staffs.keySet()))) {
            return "not-found";
        }
        if (borrow.isStudent()) {
            Student student = students.get(borrow.getUserId());
            if (!student.getPass().equals(pass)) {
                return "invalid-pass";
            }

        } else {
            Staff staff = staffs.get(borrow.getUserId());
            if (!staff.getPass().equals(pass)) {
                return "invalid-pass";
            }
        }
        Library library = libraries.get(borrow.getLibraryId());
        if (library == null) {
            return "not-found";
        }
        if (!borrow.evaluateIsBook(library.getBookIds(), library.getThesisIds())) {
            return "not-found";
        }
        Borrow borrowHelp = library.checkUserBorrows(borrow.getUserId(),borrow.getStuffId());
        if (borrowHelp== null) {
            return "not-found";
        }
        int debt = library.returning(borrowHelp,borrow.getDate());
        if (debt == 0) {
            return "success";
        }
        if (borrow.isStudent()) {
            students.get(borrow.getUserId()).setDebt(debt);
            return ""+debt;
        }
        staffs.get(borrow.getUserId()).setDebt(debt);
        return ""+debt;
    }
}

