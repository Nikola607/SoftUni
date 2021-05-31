package DefiningClasses.CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    String name;
    List<CompanyRoster> employeeList;

    public Department() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(CompanyRoster employee) {
        this.employeeList.add(employee);
    }

    public List<CompanyRoster> getEmployeeList() {
        return Collections.unmodifiableList(this.employeeList);
    }

    public double getAverageSalary() {
        double average = 0;

        for (CompanyRoster employee : this.employeeList) {
            average += employee.getSalary();
        }
        return average / this.employeeList.size();
    }
}
