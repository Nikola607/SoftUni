import java.util.Scanner;

public class AluminiumJoinery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int joineryCount = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String delivery = scan.nextLine();
        double price = 0;
        boolean isValid = false;
        if (joineryCount < 10) {
            isValid = true;
            System.out.print("Invalid order");
        }
        if (!isValid) {
            if (type.equals("90X130")) {
                price = joineryCount * 110;
                if (joineryCount > 60) {
                    price = price - 0.08 * price;
                } else if (joineryCount > 30) {
                    price = price - 0.05 * price;
                }
            } else if (type.equals("100X150")) {
                price = joineryCount * 140;
                if (joineryCount > 80) {
                    price = price - 0.1 * price;
                } else if (joineryCount > 40) {
                    price = price - 0.06 * price;
                }
            } else if (type.equals("130X180")) {
                price = joineryCount * 190;
                if (joineryCount > 50) {
                    price = price - 0.12 * price;
                } else if (joineryCount > 20) {
                    price = price - 0.07 * price;
                }
            } else if (type.equals("200X300")) {
                price = joineryCount * 250;
                if (joineryCount > 50) {
                    price = price - 0.14 * price;
                } else if (joineryCount > 25) {
                    price = price - 0.09 * price;
                }
            }
            if (delivery.equals("With delivery")) {
                price += 60;
            }
            if (joineryCount > 99) {
                price = price - 0.04 * price;
            }
            System.out.printf("%.2f BGN", price);
        }
    }
}