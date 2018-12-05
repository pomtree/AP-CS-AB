package apcs.a1;

public class Student {
    private final int ID;
    private String last_name, first_name, street, city, phone;
    private int zip;
    private double gpa;

    public Student(String _last_name, String _first_name, String _street, String _city, String _phone, int _zip, double _gpa, int _ID) {
        last_name = _last_name;
        first_name = _first_name;
        street = _street;
        city = _city;
        phone = _phone;
        zip = _zip;
        gpa = _gpa;
        ID = _ID;
    }

    public String toString() {
        return ID + "\n" + last_name + '\n' + first_name + '\n' + street + '\n' + city + '\n' + phone + "\n" + zip + "\n" + gpa;
    }

    public String getInfo() {
        return "Last name:   " + last_name + "\n" +
                "First name: " + first_name + "\n" +
                "Street:     " + street + "\n" +
                "City:       " + city + "\n" +
                "ZIP:        " + zip + "\n" +
                "Phone:      " + phone + "\n" +
                "GPA:        " + gpa + "\n";
    }

}
