import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Borrow {
    private Date date;

    private String userId;
    private String stuffId;
    private String libraryId;
    private boolean isStudent;
    private boolean isBook;

    public Borrow(Date date, String userId, String stuffId, String libraryId) {
        this.libraryId = libraryId;
        this.date = date;
        this.userId = userId;
        this.stuffId = stuffId;
    }

    public void evaluateIsStudent(HashSet<String> userIds) {
        if (userIds.contains(userId)) {
            this.isStudent = true;
            return;
        }
        this.isStudent = false;
    }
    public void evaluateIsBook(HashSet<String> stuffIds) {
        if (stuffIds.contains(stuffId)) {
            this.isBook = true;
            return;
        }
        this.isBook = false;
    }

    public Date getDate() {
        return date;
    }

    public String getUserId() {
        return userId;
    }

    public String getStuffId() {
        return stuffId;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public boolean isBook() {
        return isBook;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStuffId(String stuffId) {
        this.stuffId = stuffId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public void setBook(boolean book) {
        isBook = book;
    }
}
