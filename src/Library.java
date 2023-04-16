import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Library {
    private final String id;
    private final String name;
    private final String year;
    private final int numSeat;
    private final String address;
    private final HashMap<String, Book> books;
    private final HashMap<String, Thesis> theses;
    private final HashMap<String, ArrayList<Borrow>> borrows;

    public Library(String id, String name, String year, int numSeat, String address) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.numSeat = numSeat;
        this.address = address;
        books = new HashMap<>();
        theses = new HashMap<>();
        borrows = new HashMap<>();
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

    public HashSet<String> getBookIds() {
        return new HashSet<>(books.keySet());
    }

    public HashSet<String> getThesisIds() {
        return new HashSet<>(theses.keySet());
    }


    public boolean borrow(Borrow borrow) {
        if (borrow.isStudent()) {
            if (countBorrows(borrow.getUserId()) < 3) {
                if (isAllowed(borrow)) {
                    return true;
                }
            }
        }
            if (countBorrows((borrow.getUserId())) < 5) {
                if (isAllowed(borrow)) {
                    return true;
                }
            }
        return false;
    }

    public int countBorrows(String userId) {
        int count = 0;
        for (ArrayList<Borrow> stuffBorrows : new ArrayList<>(borrows.values())) {
            for (Borrow borrow : stuffBorrows) {
                if (borrow.getUserId().equals(userId)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countStuffs(String stuffId) {
        ArrayList<Borrow> myBorrow = borrows.get(stuffId);
        if(myBorrow == null){
            return 0;
        }
        return myBorrow.size();
    }

    public boolean isAllowed(Borrow borrow) {
        ArrayList<Borrow> borrows1 = borrows.get(borrow.getStuffId());
        if (borrows1 == null) {
            borrows1 = new ArrayList<>();
        }
        if (borrow.isBook()) {
            if (countStuffs(borrow.getStuffId()) < books.get(borrow.getStuffId()).getNumBook()) {
                borrows1.add(borrow);
                borrows.put(borrow.getStuffId(), borrows1);
                return true;
            }
            return false;
        }
        if (countStuffs(borrow.getStuffId()) == 0) {
            borrows1.add(borrow);
            borrows.put(borrow.getStuffId(), borrows1);
            return true;
        }
        return false;
    }
    public boolean checkUserBorrows(String userId) {
        for (ArrayList<Borrow> borrows1 : new ArrayList<>(borrows.values())) {
            for (Borrow borrow : borrows1) {
                if (borrow.getUserId().equals(userId)) {
                    return true;
                }
            }
        }
        return false;
    }
}



