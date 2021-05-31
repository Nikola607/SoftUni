import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product  =scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        printResult(product, quantity);
    }

    private static void printResult(String product, double quantity) {
        switch (product){
            case"coffee":
                System.out.printf("%.2f", quantity * 1.50);
                break;
            case"water":
                System.out.printf("%.2f",quantity * 1.00);
                break;
            case"coke":
                System.out.printf("%.2f",quantity * 1.40);
                break;
            case"snacks":
                System.out.printf("%.2f",quantity * 2.00);
                break;
        }
    }
}
