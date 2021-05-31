import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String people = scan.nextLine();
            String[] peopleArray = people.split(" ");
            switch (peopleArray[2]) {
                case "going!":
                    if (!guestList.contains(peopleArray[0])) {
                        guestList.add(peopleArray[0]);
                    } else {
                        System.out.printf("%s is already in the list!\n", peopleArray[0]);
                    }
                    break;
                case "not":
                    if (guestList.contains(peopleArray[0])) {
                        guestList.remove(peopleArray[0]);
                    } else {
                        System.out.printf("%s is not in the list!\n", peopleArray[0]);
                    }
                    break;
            }
        }

        for (int i = 0; i < guestList.size(); i++) {
            System.out.println(guestList.get(i));
        }
    }
}
