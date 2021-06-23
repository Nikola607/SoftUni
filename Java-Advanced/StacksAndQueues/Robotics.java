package StacksAndQueues;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(";");
        String[] robots = new String[input.length];
        int[] workTime = new int[input.length];
        int[] processTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);

            robots[i] = name;
            processTime[i] = time;
        }

        String[] startTime = scan.nextLine().split(":");

        int hours = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int second = Integer.parseInt(startTime[2]);

        int timeInSeconds = hours * 3600 + minutes * 60 + second;

        String product = scan.nextLine();
        ArrayDeque<String> deq = new ArrayDeque<>();

        while (!product.equals("End")) {
            deq.offer(product);

            product = scan.nextLine();
        }

        while (!deq.isEmpty()) {
            timeInSeconds++;

            String currentItem = deq.poll();

            boolean isWorking = false;
            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isWorking) {
                    workTime[i] = processTime[i];
                    isWorking = true;

                    printData(robots[i], currentItem, timeInSeconds);
                }

                if (workTime[i] > 0){
                    workTime[i]--;
                }

            }
            if(!isWorking){
                deq.offer(currentItem);
            }
        }
    }

    private static void printData(String robot, String currentItem, int timeInSeconds) {
        int seconds = timeInSeconds % 60;
        int minutes = (timeInSeconds / 60) % 60;
        int hours = (timeInSeconds / 3600) % 60;
        System.out.printf(robot + " - " + currentItem + " [%02d:%02d:%02d] \n", hours, minutes, seconds);
    }
}