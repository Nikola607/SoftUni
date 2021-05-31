package AssociativeArrays;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] command = scan.nextLine().split(" -> ");
        Map<String, ArrayList<String>> map = new TreeMap<>();

        while (!command[0].equals("End")) {
            String companyName = command[0];
            String employeeId = command[1];

            if(!map.containsKey(companyName)){
                map.put(companyName, new ArrayList<>());
            }
            if (map.containsKey(companyName) && !map.get(companyName).contains(employeeId)) {
                map.get(companyName).add(employeeId);
            }

            command = scan.nextLine().split(" -> ");
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (String i : entry.getValue()) {
                System.out.println("-- " + i);
            }
        }
    }
}
