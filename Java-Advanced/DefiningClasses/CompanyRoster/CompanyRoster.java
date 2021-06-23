package DefiningClasses.CompanyRoster;

public class CompanyRoster {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public CompanyRoster(String name, double salary, String department,String position) {
        this(name, salary, position, department,"n/a", -1);
    }

    public CompanyRoster(String name, double salary, String position, String department,String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public CompanyRoster(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }
    public CompanyRoster(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d\n", name, salary, email, age);
    }
}
