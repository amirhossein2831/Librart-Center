public class Thesis {
    private String id;
    private String name;
    private String studentName;
    private String advisor;
    private String year;
    private String categoryId;
    private String libraryId;

    public Thesis(String id, String name, String studentName, String advisor, String year, String categoryId, String libraryId) {
        this.id = id;
        this.name = name;
        this.studentName = studentName;
        this.advisor = advisor;
        this.year = year;
        this.categoryId = categoryId;
        this.libraryId = libraryId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getAdvisor() {
        return advisor;
    }

    public String getYear() {
        return year;
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

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
