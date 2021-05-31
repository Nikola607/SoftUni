import java.util.Scanner;

public class FootballResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstResult = scan.nextLine();
        String secondResult = scan.nextLine();
        String thirdResult = scan.nextLine();
        int wonGames = 0;
        int lostGames = 0;
        int drawGames  =0;

        int result1 = firstResult.charAt(0);
        int result2 = firstResult.charAt(2);
        if(result1> result2){
            wonGames++;
        }else if (result1< result2){
            lostGames++;
        }else if(result1 == result2){
            drawGames++;
        }
        int result11 = secondResult.charAt(0);
        int result22 = secondResult.charAt(2);
        if(result11> result22){
            wonGames++;
        }else if (result11< result22){
            lostGames++;
        }else if(result11 == result22){
            drawGames++;
        }
        int result111 = thirdResult.charAt(0);
        int result222 = thirdResult.charAt(2);
        if(result111> result222){
            wonGames++;
        }else if (result111< result222){
            lostGames++;
        }else if(result111 == result222){
            drawGames++;
        }
        System.out.printf("Team won %d games.\n", wonGames);
        System.out.printf("Team lost %d games.\n", lostGames);
        System.out.printf("Drawn games: %d", drawGames);
    }
}
