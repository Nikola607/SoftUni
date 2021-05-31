package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> deqUrl = new ArrayDeque<>();
        ArrayDeque<String> deqForward = new ArrayDeque<>();
        String command = scan.nextLine();

        while (!command.equals("Home")) {
            switch (command) {
                case "back":
                    if (deqUrl.size() > 1) {
                        String currentUrl = deqUrl.pop();
                        deqForward.push(currentUrl);
                        System.out.println(deqUrl.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;
                case "forward":
                    if (!deqForward.isEmpty()) {
                        String currentForward = deqForward.pop();
                        System.out.println(currentForward);
                        deqUrl.push(currentForward);
                    } else {
                        System.out.println("no next URLs");
                    }
                    break;
                default:
                    deqUrl.push(command);
                    System.out.println(command);
                    deqForward.clear();
                    break;
            }
            command = scan.nextLine();
        }
    }
}
