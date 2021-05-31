import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfGroups = Integer.parseInt(scan.nextLine());
        int groupForMusala = 0;
        int groupForMonblan = 0;
        int groupForKilimandjaro = 0;
        int groupForK9 = 0;
        int groupForEverest = 0;

        for (int i = 1; i <= numberOfGroups; i++) {
            int peopleInGroup = Integer.parseInt(scan.nextLine());
            if (peopleInGroup>0 && peopleInGroup <= 5){
                groupForMusala +=peopleInGroup;
            }else if(peopleInGroup>=6 && peopleInGroup<=12){
                groupForMonblan +=peopleInGroup;
            }else if(peopleInGroup >=13 && peopleInGroup<=25){
                groupForKilimandjaro +=peopleInGroup;
            }else if (peopleInGroup >=26 && peopleInGroup<=40){
                groupForK9 +=peopleInGroup;

            }else{
                groupForEverest+=peopleInGroup;
            }
        }
        int allPeople = groupForEverest + groupForK9 + groupForKilimandjaro + groupForMonblan + groupForMusala;
        System.out.printf("%.2f%%\n", groupForMusala * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%\n", groupForMonblan * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%\n", groupForKilimandjaro * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%\n", groupForK9 * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%", groupForEverest * 1.0 / allPeople * 100);
    }
}
