package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<StudentData> list = new ArrayList<>();

        while (!command.equals("end")) {
            String[] data = command.split(" ");
            StudentData s = new StudentData(data[0], data[1], Integer.parseInt(data[2]), data[3]);
            int check = StudentCheck(list, s.getFirstName(), s.getLastName());
            if(check!=-1)
            {
                list.get(check).setAge(s.age);
                list.get(check).setHomeTown(s.homeTown);
            }else {
                list.add(s);
            }

            command = scan.nextLine();
        }

        String townNeeded = scan.nextLine();

        for (StudentData i : list) {
            if (townNeeded.equals(i.getHomeTown())) {
                System.out.printf("%s %s is %d years old\n", i.getFirstName(), i.getLastName(), i.getAge());
            }
        }
    }

    private static int StudentCheck(List<StudentData> list, String firstName, String lastName) {
        for(int i = 0; i<list.size(); i++)
        {
            if(list.get(i).getFirstName().equals(firstName) &&
            list.get(i).getLastName().equals(lastName)){
                return i;
            }
        }
        return -1;
    }


    static class StudentData {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public StudentData(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

    }
}
