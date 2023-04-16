public class Student {
    private String id;
    private String pass;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String year;
    private String address;
    private int debt;

    public Student(String id, String pass, String firstName, String lastName, String nationalId, String year, String address) {
        this.id = id;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.year = year;
        this.address = address;
        debt = 0;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }
    public int getDebt() {
        return debt;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public void edit(Student student) {
        if (!student.getPass().equals("-")) {
            setPass(student.getPass());
        }
        if (!student.getFirstName().equals("-")) {
            setFirstName(student.getFirstName());
        }
        if (!student.getLastName().equals("-")) {
            setLastName(student.getLastName());
        }
        if (!student.getNationalId().equals("-")) {
            setNationalId(student.getNationalId());
        }
        if (!student.getYear().equals("-")) {
            setYear(student.getYear());
        }
        if (!student.getAddress().equals("-")) {
            setAddress(student.getAddress());
        }
    }
}
