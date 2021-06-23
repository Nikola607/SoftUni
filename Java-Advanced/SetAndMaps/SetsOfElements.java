package SetAndMaps;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        int firstLength = input[0];
        int secondLength = input[1];
        List<Integer> list = new ArrayList<>();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        addingElements(scan, firstSet, firstLength, list);
        addingElements(scan, secondSet, secondLength, list);

        Set<Integer> thirdSet = new LinkedHashSet<>();

        checkingElements(firstSet, secondSet, list, thirdSet );

        thirdSet.forEach(e -> System.out.print(e + " "));
    }

    private static void checkingElements(Set<Integer> biggerSet, Set<Integer> smallerSet, List<Integer> list, Set<Integer> thirdSet) {
        for (int i = 0; i < list.size(); i++) {
            if(biggerSet.contains(list.get(i)) && smallerSet.contains(list.get(i))){
                thirdSet.add(list.get(i));
            }
        }
    }

    public static void addingElements(Scanner scan, Set<Integer> set, int length, List<Integer> list) {

        for (int i = 0; i < length; i++) {
            int currentNumber = Integer.parseInt(scan.nextLine());
            set.add(currentNumber);
            list.add(currentNumber);
        }
    }
}