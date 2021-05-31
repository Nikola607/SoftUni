import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.next().split(" ");

        List<String> line = new ArrayList<>();
        String command = scan.nextLine();

        while (!command.equals("3:1")) {
            String[] commandArray = command.split(" ");
            switch (commandArray[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int endIndex = Integer.parseInt(commandArray[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > line.size()) {
                        endIndex = line.size() - 1;
                    }

                    for (int i = startIndex; i < endIndex; i++) {
                        String merge = line.get(startIndex) + line.get(startIndex + 1);
                        line.set(startIndex, merge);
                        line.remove(startIndex + 1);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(commandArray[1]);
                    int partition = Integer.parseInt(commandArray[2]);
                    String randomKur = line.get(index);
                    if(randomKur.length()%partition==0){
                        for(int i = 0; i<randomKur.length(); i++){
                            if(i%partition==0){
                                System.out.print(randomKur.charAt(i));
                            }
                        }
                    }
                    break;
            }
            command = scan.nextLine();
        }
        for(int i = 0; i<line.size(); i++){
            System.out.println(line.get(i) + " ");
        }
    }
}
