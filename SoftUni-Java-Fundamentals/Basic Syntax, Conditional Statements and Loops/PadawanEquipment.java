import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        int countOfStudents = Integer.parseInt(scan.nextLine());
        double priceSword = Double.parseDouble(scan.nextLine());
        double priceRobe = Double.parseDouble(scan.nextLine());
        double priceBelts = Double.parseDouble(scan.nextLine());

        double moneyForSwords = Math.ceil(countOfStudents + countOfStudents * 0.1) *priceSword;
        double moneyForBelts = 0;
        double moneyForRobes = countOfStudents * priceRobe;

        for (int belts = 1; belts <= countOfStudents; belts++) {
            if (belts % 6 == 0) {
                moneyForBelts += 0;
            } else {
                moneyForBelts += priceBelts;
            }
        }
        double finalPrice = moneyForSwords + moneyForBelts + moneyForRobes;
        if (finalPrice <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", finalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", finalPrice - money);
        }
    }
}
