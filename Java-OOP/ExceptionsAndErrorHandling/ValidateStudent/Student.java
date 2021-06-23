package ExceptionsAndErrorHandling.ValidateStudent;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public void setName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isDigit(name.charAt(i))) {
                throw new InvalidPersonNameException("The name cannot contain any special characters or numeric value");
            }
        }
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
