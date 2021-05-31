import java.util.Scanner;

public class FitnessCenter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleTraining = Integer.parseInt(scan.nextLine());
        int back = 0;
        int chest = 0;
        int legs = 0;
        int abs = 0;
        int proteinShake = 0;
        int proteinBar = 0;
        double peopleCameToTrain = 0;
        double peopleComeToBuy = 0;

        for(int i = 1; i<=peopleTraining; i++){
            String action = scan.nextLine();
            switch(action){
                case"Back":
                    back++;
                    peopleCameToTrain++;
                    break;
                case"Chest":
                    chest++;
                    peopleCameToTrain++;
                    break;
                case"Legs":
                    legs++;
                    peopleCameToTrain++;
                    break;
                case"Abs":
                    abs++;
                    peopleCameToTrain++;
                    break;
                case"Protein shake":
                    proteinShake++;
                    peopleComeToBuy++;
                    break;
                case"Protein bar":
                    proteinBar++;
                    peopleComeToBuy++;
                    break;
            }
        }
        System.out.printf("%d - back\n", back);
        System.out.printf("%d - chest\n", chest);
        System.out.printf("%d - legs\n", legs);
        System.out.printf("%d - abs\n", abs);
        System.out.printf("%d - protein shake\n", proteinShake);
        System.out.printf("%d - protein bar\n", proteinBar);
        System.out.printf("%.2f%% - work out\n", peopleCameToTrain / peopleTraining * 100);
        System.out.printf("%.2f%% - protein", peopleComeToBuy / peopleTraining * 100);
    }
}
