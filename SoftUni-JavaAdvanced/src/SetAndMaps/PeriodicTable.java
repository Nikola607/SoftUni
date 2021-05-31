package SetAndMaps;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        Set<String> elements = new TreeSet<>();

        for(int i = 0; i<num; i++){
            addingElements(scan, elements);
        }

        elements.forEach(e -> System.out.print(e + " "));
    }

    private static void addingElements(Scanner scan, Set<String> elements) {
        String[] currentElements = scan.nextLine().split(" ");
        elements.addAll(Arrays.asList(currentElements));
    }
}
