import java.util.Scanner;

public class ReverseStringsOfArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");

        for(int i = 0; i<arr.length / 2; i++){
            String oldElements = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = oldElements;
        }
        System.out.print(String.join(" ", arr));
    }
}
