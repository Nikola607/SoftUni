import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        int  wide = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int freeSpace = length * wide * height;
        int sum = 0;

        while(!input.equals("Done")){
            int boxes= Integer.parseInt(input);
            sum +=boxes;
            if(freeSpace<sum){
                int neededSpace = freeSpace - sum;
                System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(neededSpace));
               break;
            }
            input = scan.nextLine();
        }
        if(input.equals("Done")) {
            int leftSpace = freeSpace - sum;
            System.out.printf("%d Cubic meters left.", Math.abs(leftSpace));
        }
    }
}
