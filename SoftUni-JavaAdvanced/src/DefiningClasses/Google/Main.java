package DefiningClasses.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split("\\s+");
        Map<String, Person> personMap = new LinkedHashMap<>();

        while (!data[0].equals("End")) {
            String name = data[0];
            Person person = new Person(name);

            personMap.putIfAbsent(name, person);

            switch (data[1]) {
                case "company":
                    name = data[0];
                    String companyName = data[2];
                    String companyDepartment = data[3];
                    double salary = Double.parseDouble(data[4]);

                    Company company = new Company(companyName, companyDepartment, salary);
                    personMap.get(name).setCompany(company);
                    break;
                case "car":
                    name = data[0];
                    String model = data[2];
                    int carSpeed = Integer.parseInt(data[3]);

                    Car car = new Car(model, carSpeed);
                    personMap.get(name).setCar(car);
                    break;
                case "pokemon":
                    name = data[0];
                    String pokemonName = data[2];
                    String pokemonType = data[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    personMap.get(name).getPokemon().add(pokemon);
                    break;
                case "parents":
                    name = data[0];
                    String parentsName = data[2];
                    String parentsBirthday = data[3];

                    Parents parents = new Parents(parentsName, parentsBirthday);
                    personMap.get(name).setParents(parents);
                    break;
                case "children":
                    name = data[0];
                    String childrenName = data[2];
                    String childrenBirthday = data[3];

                    Children children = new Children(childrenName, childrenBirthday);
                    personMap.get(name).getChildren().add(children);
                    break;
            }
            data = scan.nextLine().split("\\s+");
        }

        String neededPerson = scan.nextLine();

        System.out.println(personMap.get(neededPerson));
    }
}
