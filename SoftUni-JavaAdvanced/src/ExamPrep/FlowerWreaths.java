package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> lilies = Arrays.stream(scan.nextLine().split(", ")).
                mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> roses = Arrays.stream(scan.nextLine().split(", ")).
                map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int mixed = 0;

        List<Integer> smallSum = new ArrayList<>();

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int lastLily = lilies.pollLast();
            int firsRose = roses.pollFirst();

            int sum = lastLily + firsRose;

            if (sum > 15) {
                lastLily--;
                firsRose--;

                lilies.addLast(lastLily);
                roses.push(firsRose);

                continue;
            } else if (sum < 15) {
                smallSum.add(sum);
            } else {
                mixed++;
            }
        }

        double smallSumMix = 0;

        for (int i = 0; i < smallSum.size(); i++) {
            int currentSum = smallSum.get(i);

            smallSumMix += currentSum;
        }

        while (smallSumMix >= 15){
            smallSumMix-=15;
            mixed++;
        }

        if (mixed >= 5) {
            System.out.println("You made it, you are going to the competition with " + mixed + " wreaths!");
        } else {
            System.out.printf("You didn't make it, you need %s wreaths more! ",5 - mixed);
        }
    }
}
