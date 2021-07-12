import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {
        System.out.println("Select exercise number:");
        int exNum = 0;

        try {
            exNum = Integer.parseInt(bufferedReader.readLine());

            switch (exNum) {
                case 2 -> exTwo();
                case 3 -> exThree();
                case 4 -> exFour();
                case 5 -> exFive();
                case 6 -> exSix();
                case 7 -> exSeven();
                case 8 -> exEight();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exEight() throws IOException {
        System.out.println("Input employee id");

        int id = Integer.parseInt(bufferedReader.readLine());

        entityManager.createQuery("select e from Employee e " +
                "where e.id = :e_id", Employee.class)
                .setParameter("e_id", id)
                .getResultList().forEach(e -> {
            System.out.printf("%s %s - %s\n", e.getFirstName(), e.getLastName(), e.getJobTitle());

            Set<Project> projectSet = e.getProjects();
            List<String> names = new ArrayList<>();
            projectSet.forEach(p -> {
                names.add(p.getName());
            });

            Collections.sort(names);

            names.forEach(System.out::println);

        });

    }

    private void exSeven() {
        System.out.println("Addresses with Employee Count");

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address  AS a " +
                "ORDER BY a.employees.size DESC ",Address.class)
                .getResultList();

        addresses.stream().limit(10)
                .forEach(a ->{
                    System.out.printf("%s, %s - %d employees \n",
                            a.getText(),
                            a.getTown() == null ? "Unknown" : a.getTown().getName(),
                            a.getEmployees().size());
                });
    }

    private void exSix() throws IOException {
        System.out.println("Enter employee last name:");

        String lastName = bufferedReader.readLine();
        Employee employee = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.lastName = :e_last", Employee.class)
                .setParameter("e_last", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();

        entityManager.persist(address);

        entityManager.getTransaction().commit();
        return address;
    }

    private void exFive() {
        System.out.println("Employees from Department");

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.department.name = :d_name " +
                "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultList();

        employees
                .forEach(e -> System.out.printf("%s %s from Research and Development - $%.2f \n",
                        e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void exFour() {
        System.out.println("Employees with Salary Over 50 000");

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee AS e " +
                " WHERE e.salary > 50000", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }

    private void exThree() throws IOException {
        System.out.println("Enter employee name:");

        String[] employeeName = bufferedReader.readLine().split(" ");
        String firstName = employeeName[0];
        String lastName = employeeName[1];

        try {
            entityManager.createQuery("SELECT e " +
                    "FROM Employee AS e WHERE e.firstName = :e_first AND e.lastName = :e_last", Employee.class)
                    .setParameter("e_first", firstName)
                    .setParameter("e_last", lastName)
                    .getSingleResult();
            System.out.println("Yes");
        }catch (NoResultException  exception){
            System.out.println("No");
        }
    }

    private void exTwo() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town AS t " +
                "Set t.name = UPPER(t.name) " +
                "WHERE length(t.name) <= 5");

        System.out.println(query.executeUpdate() + " rows affected.");

        entityManager.getTransaction().commit();
    }
}
