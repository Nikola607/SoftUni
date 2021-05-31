import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movie = scan.nextLine();
        int freeSeats = Integer.parseInt(scan.nextLine());
        int takenSeats = 0;
        int totalTickets = 0;
        int countStudentTickets = 0;
        int standardTickets = 0;
        int kidsTickets = 0;

        while(!movie.equals("Finish")){
            while(true) {
                String ticketType = scan.nextLine();
                totalTickets++;
                takenSeats++;
                switch(ticketType){
                    case "student":
                        countStudentTickets++;
                        break;
                    case"standard":
                        standardTickets++;
                        break;
                    case"kids":
                        kidsTickets++;
                        break;
                }
                if(ticketType.equals("End")) {
                    break;
                }
                if(takenSeats > freeSeats){
                    break;
                }
            }
            double percentTaken = (takenSeats * 1.0) / freeSeats * 100;
            System.out.printf("%s - %.2f full.\n", movie, percentTaken);
            movie = scan.nextLine();
        }
        if(movie.equals("Finish")){
            System.out.printf("Total tickets %d.\n", totalTickets);
            double percentStudent = countStudentTickets * 1.0 / totalTickets * 100;
            System.out.printf("%.2f student tickets.\n", percentStudent);
            double percentStandard = standardTickets * 1.0 / totalTickets *  100;
            System.out.printf("%.2f standard tickets.\n", percentStandard);
            double percentKids = kidsTickets + 1.0 / totalTickets * 100;
            System.out.printf("%.2f kids tickets.", percentKids);
        }
    }
}
