import java.awt.*;
import java.util.*;

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


    public boolean borrow(Borrow borrow,int userBorrow) {
        if (borrow.isStudent()) {
            if (userBorrow < 3) {
                if (isAllowed(borrow)) {
                    return true;
                }
            }
        }
        else {
            if (userBorrow < 5) {
                if (isAllowed(borrow)) {
                    return true;
                }
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
    public Borrow checkUserBorrows(String userId) {
        Borrow borr = null;
        for (ArrayList<Borrow> borrows1 : new ArrayList<>(borrows.values())) {
            for (Borrow borrow : borrows1) {
                if (borrow.getUserId().equals(userId)) {
                    if (borr == null) {
                        borr = borrow;
                    } else if (borr.getDate().getTime() < borrow.getDate().getTime()) {
                        borr = borrow;
                    }
                }
            }
        }
        return borr;
    }
    public Borrow checkUserBorrows(String userId,String stuffId) {
        Borrow borr = null;
        ArrayList<Borrow> hold = borrows.get(stuffId);
        if (hold == null) {
            return null;
        }
        for (Borrow borrow : hold) {
            if (borrow.getUserId().equals(userId)) {
                if (borr == null) {
                    borr = borrow;
                } else if (borr.getDate().getTime() < borrow.getDate().getTime()) {
                    borr = borrow;
                }
            }
        }
        return borr;
    }

    public int checkDebt(Borrow borrow, Date returnTime) {
        long firstMin = borrow.getDate().getTime() / 3600000;
        long secondMin =  returnTime.getTime() / 3600000;
        long periodTime = secondMin - firstMin;
        if (borrow.isStudent()) {
            if (borrow.isBook()) {
                if (periodTime < (10 * 24)) {
                    return 0;
                }
                return (int) ((periodTime - (10 * 24)) * 50);
            }
            if (periodTime < (7 * 24)) {
                return 0;
            }
            return (int) ((periodTime - (7 * 24)) * 50);
        }
        if (borrow.isBook()) {
            if (periodTime < (14 * 24)) {
                return 0;
            }
            return (int) ((periodTime - (14 * 24)) * 100);
        }
        if (periodTime < (10 * 24)) {
            return 0;
        }
        return (int) ((periodTime - (10 * 24)) * 100);
    }

    public int returning(Borrow borrow, Date returnTime) {
        ArrayList<Borrow> borrows1 = borrows.get(borrow.getStuffId());
        int debt = checkDebt(borrow, returnTime);
        borrows1.remove(borrow);
        return debt;
    }

    public HashSet<String>search(String key) {
        HashSet<String > output = new HashSet<>();
        for (Book book : books.values()) {
            if (book.getName().toLowerCase().contains(key.toLowerCase())) {
                output.add(book.getId());
            }
            if (book.getAuthorName().toLowerCase().contains(key.toLowerCase())) {
                output.add(book.getId());
            }
            if (book.getPublisher().toLowerCase().contains(key.toLowerCase())) {
                output.add(book.getId());
            }
        }
        for (Thesis thesis : theses.values()) {
            if (thesis.getName().toLowerCase().contains(key.toLowerCase())) {
                output.add(thesis.getId());
            }
            if (thesis.getStudentName().toLowerCase().contains(key.toLowerCase())) {
                output.add(thesis.getId());
            }
            if (thesis.getAdvisor().toLowerCase().contains(key.toLowerCase())) {
                output.add(thesis.getId());
            }
        }
        return output;
    }

    public Point categoryReport(String categoryId) {
        int bookNum = 0;
        int thesisNum = 0;
        for (Book book : books.values()) {
            if (book.getCategoryId().equals(categoryId)) {
                bookNum+=book.getNumBook();
            }
        }
        for (Thesis thesis : theses.values()) {
            if (thesis.getCategoryId().equals(categoryId)) {
                thesisNum++;
            }
        }
        return new Point(bookNum, thesisNum);
    }

    public String libraryReport() {
        int allBookNum = 0;
        int allThesisNum = theses.size();
        int borrowedBoolNum = 0;
        int borrowedThesisNum = 0;
        for (Book book : books.values()) {
            allBookNum += book.getNumBook();
        }
        for (ArrayList<Borrow> borrows1 : new ArrayList<>(borrows.values())) {
            for (Borrow borrow : borrows1) {
                if (borrow.isBook()) {
                    borrowedBoolNum++;
                }
                else
                    borrowedThesisNum++;
            }
        }
        return allBookNum + " " + allThesisNum + " " + borrowedBoolNum + " " + borrowedThesisNum;
    }

    public StringBuilder reportPassedDeadline(Date date) {
        HashSet<String> outPut = new HashSet<>();
        StringBuilder hold = new StringBuilder();
        for (ArrayList<Borrow> borrows1 : new ArrayList<>(borrows.values())) {
            for (Borrow borrow : borrows1) {
                if (checkDebt(borrow, date) != 0) {
                    outPut.add(borrow.getStuffId());
                }
            }
        }
        ArrayList<String> outputArray = new ArrayList<>(outPut);
        Collections.sort(outputArray);
        for (String i : outputArray) {
            hold.append(i);
            hold.append("|");
        }
        return hold;
    }
}



