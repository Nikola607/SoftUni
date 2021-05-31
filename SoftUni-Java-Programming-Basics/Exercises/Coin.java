import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double changeLv = Double.parseDouble(scan.nextLine());
        double changeSt = Math.round(changeLv * 100);
        int countCoins = 0;

        while (changeSt > 0) {
            if (changeSt >= 200) {
                changeSt -= 200;
                countCoins++;
            } else if (changeSt >= 100) {
                changeSt -= 100;
                countCoins++;
            } else if (changeSt >= 50) {
                changeSt -= 50;
                countCoins++;
            } else if (changeSt >= 20) {
                changeSt -= 20;
                countCoins++;
            } else if (changeSt >= 10) {
                changeSt -= 10;
                countCoins++;
            } else if (changeSt >= 5) {
                changeSt -= 5;
                countCoins++;
            } else if (changeSt >= 2) {
                changeSt -= 2;
                countCoins++;
            } else {
                changeSt -= 1;
                countCoins++;
            }
        }
        System.out.println(countCoins);
    }
}
