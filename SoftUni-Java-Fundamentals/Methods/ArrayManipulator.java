import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String line = scan.nextLine();

        while (!line.equals("end")) {
            String[] inputArray = line.split(" ");
            String command = inputArray[0];
            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(inputArray[1]);
                    if (index >= 0 && index < numbers.length) {
                        exchangeArray(numbers, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String type = inputArray[1];
                    if (type.equals("odd")) {

                    } else {

                    }
                    break;
                case "min":
                    if (inputArray[1].equals("odd")) {

                    } else {

                    }
                    break;
                case "first":
                    int count = Integer.parseInt(inputArray[1]);
                    if (count > numbers.length) {
                        System.out.println("Invalid count");
                    } else if (inputArray[2].equals("odd")) {

                    } else {

                    }
                    break;
                case "last":
                    int countLast =Integer.parseInt(inputArray[1]);
                    if (countLast > numbers.length) {
                        System.out.println("Invalid count");
                    } else if (inputArray[2].equals("odd")) {

                    } else {

                    }
                    break;
            }
            line = scan.nextLine();
        }
        System.out.println(Arrays.toString(numbers));
    }
    private static void exchangeArray (int[] arr, int index){
        int[] first = new int[index + 1];
        int[] second = new int[arr.length - index + 1];
        for(int i =0; i<=index; i++){
            first[i] = arr[i];
        }
        for(int i = index + 1; i<arr.length; i++){
            second[i - (index + 1)] = arr[i];
        }
        for(int i = 0; i<second.length; i++){
            arr[i] = second[i];
        }
        for(int i =0;i<first.length; i++){
            arr[i + second.length] = first[i];
        }
    }
}
