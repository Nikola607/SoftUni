import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String searchedBook = scan.nextLine();
        String command = scan.nextLine();
        int checkedBooks = 0;
        while(!command.equals("No more books")){
            if(command.equals(searchedBook)){
                System.out.printf("You checked %d books and found it.", checkedBooks);
                break;
            }else{
                checkedBooks++;
            }
            command=scan.nextLine();
        }
        if(command.equals("No more books")){
            System.out.println("The book you search is not here.");
            System.out.printf("You checked %d books.", checkedBooks);
        }
    }
}
