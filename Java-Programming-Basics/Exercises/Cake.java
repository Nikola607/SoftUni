import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int widthCake = Integer.parseInt(scan.nextLine());
        int lengthCake= Integer.parseInt(scan.nextLine());
        int pieces = widthCake * lengthCake;

        while (pieces > 0){
            String command = scan.nextLine();
            if(command.equals("Stop")){
                break;
            }else{
                int takenPieces= Integer.parseInt(command);
                pieces -= takenPieces;
            }
        }
        if(pieces >= 0 ){
            System.out.printf("%d pieces are left.", pieces);
        }else{
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(pieces));
        }
    }
}
