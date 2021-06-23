package DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Department> map = new TreeMap<>();

        while (n-- > 0) {
            String[] data = scan.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            map.putIfAbsent(department, new Department());
            CompanyRoster employees = null;
            if (data.length == 6) {
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employees = new CompanyRoster(name, salary, position, department, email, age);
            }else if(data.length == 4){
                employees = new CompanyRoster(name, salary, position, department);
            }else if(data.length == 5){
                if(data[4].contains("@")){
                    String email = data[4];
                    employees = new CompanyRoster(name, salary, position, department, email);
                }else{
                    int age = Integer.parseInt(data[4]);
                    employees = new CompanyRoster(name, salary, position, department, age);
                }
            }
            map.get(department).addEmployee(employees);
        }

        double bestSalary = 0;
        String bestDepartment = "";

        for(Map.Entry<String, Department> department : map.entrySet()){
            if(department.getValue().getAverageSalary() > bestSalary){
                bestSalary = department.getValue().getAverageSalary();
                bestDepartment = department.getKey();
            }
        }

        System.out.println("Highest Average Salary: " + bestDepartment);
        Department department = map.get(bestDepartment);

        department.getEmployeeList().
                stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).
                forEach(e -> System.out.print(e));
    }
}
