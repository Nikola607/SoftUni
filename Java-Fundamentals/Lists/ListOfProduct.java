import java.util.*;

public class ListOfProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> products = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String currentProduct = scan.nextLine();
            products.add(currentProduct);
        }
        Collections.sort(products);
        for (int i = 0; i <= products.size() - 1; i++) {
            System.out.printf("%d.%s\n", i + 1, products.get(i));
        }
    }
}
