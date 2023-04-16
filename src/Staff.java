public class Staff {
    private String id;
    private String pass;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String year;
    private String address;


    public Staff(String id, String pass, String firstName, String lastName, String nationalId, String year, String address) {
        this.id = id;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.year = year;
        this.address = address;
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

    public void edit(Staff staff) {
        if (!staff.getPass().equals("-")) {
            setPass(staff.getPass());
        }
        if (!staff.getFirstName().equals("-")) {
            setFirstName(staff.getFirstName());
        }
        if (!staff.getLastName().equals("-")) {
            setLastName(staff.getLastName());
        }
        if (!staff.getNationalId().equals("-")) {
            setNationalId(staff.getNationalId());
        }
        if (!staff.getYear().equals("-")) {
            setYear(staff.getYear());
        }
        if (!staff.getAddress().equals("-")) {
            setAddress(staff.getAddress());
        }
    }
}
