package AssociativeArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestOf3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());

        for(int i = 0; i<list.size(); i++){
            if(i<3) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
