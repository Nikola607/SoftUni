import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String searchedBook = scan.nextLine();
        String book = scan.nextLine();
        int booksChecked = 0;

        while (!book.equals("No More Books")) {
            if (searchedBook.equals(book)) {
                System.out.printf("You checked %d books and found it.", booksChecked);
                break;
            }
            book = scan.nextLine();
            booksChecked++;
        }
        if(book.equals("No More Books")){
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", booksChecked);
        }
    }
}
