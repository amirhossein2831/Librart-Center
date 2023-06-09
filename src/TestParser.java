import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestParser {
    private Center center;


    public TestParser() {
        center = new Center();
    }

    public void parseCommand(String input) throws ParseException {
        String[] command = input.split("#");
        String[] args = new String[]{};
        if (command.length > 1) {
            args = command[1].split("\\|");
        }
        switch (command[0]) {
            case "add-library":
                addLibrary(args[0],args[1],args[2],Integer.parseInt(args[3]),args[4]);
                break;
            case "add-category":
                addCategory(args[0], args[1]);
                break;
            case "add-book":
                addBook(args[0], args[1], args[2], args[3], args[4], Integer.parseInt(args[5]), args[6], args[7]);
                break;
            case "edit-book":
                if (args[6].equals("-")) {
                    editBook(args[0], args[1], args[2], args[3], args[4],args[5],-1, args[7]);
                }
                else
                    editBook(args[0], args[1], args[2], args[3], args[4],args[5], Integer.parseInt(args[6]), args[7]);
                break;
            case "add-thesis":
                    addThesis(args[0], args[1], args[2], args[3], args[4],args[5],args[6]);
                break;
            case "edit-thesis":
                editThesis(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                break;
            case "remove-book":
                removeBook(args[0], args[1]);
                break;
            case "remove-thesis":
                removeThesis(args[0], args[1]);
                break;
            case "add-student":
                addStudent(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                break;
            case "edit-student":
                editStudent(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                break;
            case "remove-student":
                removeStudent(args[0]);
                break;
            case "add-staff":
                addStaff(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                break;
            case "edit-staff":
                editStaff(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                break;
            case "remove-staff":
                removeStaff(args[0]);
                break;
            case "borrow":
                borrow(args[0], args[1], args[2], args[3], args[4], args[5]);
                break;
            case "return":
                returning(args[0], args[1], args[2], args[3], args[4], args[5]);
                break;
            case "search":
                search(args[0]);
                break;
            case "search-user":
                searchUser(args[0], args[1], args[2]);
                break;
            case "report-penalties-sum":
                reportPenalties();
                break;
            case "library-report":
                libraryReport(args[0]);
                break;
            case "category-report":
                categoryReport(args[0]);
                break;
            case "report-passed-deadline":
                reportPasseDeadline(args[0], args[1], args[2]);
                break;
        }
    }
    public void addLibrary(String id, String name, String year, int numSeat, String address) {
        Library library = new Library(id, name, year, numSeat, address);
        System.out.println(center.addLibrary(library));
    }

    public void addCategory(String id, String name) {
        Category category = new Category((id), name);
        System.out.println(center.addCategory(category));
    }

    public void addBook(String id, String name, String authorName, String publisher, String year, int numBook, String categoryId, String libraryId) {
        Book book = new Book(id, name, authorName, publisher, year, numBook, categoryId, libraryId);
        System.out.println(center.addBook(book));
    }

    public void editBook(String id,String libraryId ,String name, String authorName, String publisher, String year, int numBook, String categoryId) {
        Book book = new Book(id, name, authorName, publisher, year, numBook, categoryId, libraryId);
        System.out.println(center.editBook(book));
    }

    public void addThesis(String id, String name, String studentName, String advisor, String year, String categoryId, String libraryId) {
        Thesis thesis = new Thesis(id, name, studentName, advisor, year, categoryId, libraryId);
        System.out.println(center.addThesis(thesis));
    }

    public void editThesis(String id, String libraryId, String name, String studentName, String advisor, String year, String categoryID) {
        Thesis thesis = new Thesis(id, name, studentName, advisor, year, categoryID, libraryId);
        System.out.println((center.editThesis(thesis)));
    }

    public void removeBook(String bookId, String libraryId) {
        System.out.println(center.removeBook(bookId, libraryId));
    }

    public void removeThesis(String thesisId, String libraryId) {
        System.out.println(center.removeThesis(thesisId, libraryId));
    }

    public void addStudent(String id, String pass, String firstName, String lastName, String nationalId, String year, String address) {
        Student student = new Student(id, pass, firstName, lastName, nationalId, year, address);
        System.out.println(center.addStudent(student));
    }

    public void editStudent(String id, String pass, String firstName, String lastName, String notionalId, String year, String address) {
        Student student = new Student(id, pass, firstName, lastName, notionalId, year, address);
        System.out.println(center.editStudent(student));
    }

    public void removeStudent(String id) {
        System.out.println(center.removeStudent(id));
    }

    public void addStaff(String id, String pass, String firstName, String lastName, String notionalId, String year, String address) {
        Staff staff = new Staff(id, pass, firstName, lastName, notionalId, year, address);
        System.out.println(center.addStaff(staff));
    }

    public void editStaff(String id, String pass, String firstName, String lastName, String notionalId, String year, String address) {
        Staff staff = new Staff(id, pass, firstName, lastName, notionalId, year, address);
        System.out.println(center.editStaff(staff));
    }

    public void removeStaff(String id) {
        System.out.println(center.removeStaff(id));
    }

    public void borrow(String userId, String pass, String libraryId, String stuffId, String strDate, String hour) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(strDate + " " + hour);
        Borrow borrow = new Borrow(date, userId, stuffId, libraryId);
        System.out.println(center.borrow(borrow,pass));
    }

    public void returning(String userId, String pass, String libraryId, String stuffId, String strDate, String hour) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(strDate + " " + hour);
        Borrow borrow = new Borrow(date, userId, stuffId, libraryId);
        System.out.println(center.returning(borrow,pass));
    }

    public void search(String key) {
        System.out.println(center.search(key));
    }

    public void searchUser(String userId, String pass, String key) {
        System.out.println(center.searchUser(userId, pass, key));
    }
    public void reportPenalties() {
        System.out.println(center.reportPenalties());
    }

    public void categoryReport(String categoryId) {
        System.out.println(center.categoryReport(categoryId));
    }

    public void libraryReport(String libraryId) {
        System.out.println(center.libraryReport(libraryId));
    }

    public void reportPasseDeadline(String libraryId, String strDate, String hour) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(strDate + " " + hour);
        System.out.println(center.reportPasseDeadline(libraryId, date));
    }
}
