package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Music>list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            String[] command = scan.nextLine().split("_");
            Music s = new Music(command[0], command[1], command[2]);

            list.add(s);
        }
        String givenType = scan.nextLine();
        for(Music i:list){
            if(givenType.equals(i.getType())){
                System.out.println(i.getName());
            }else if(givenType.equals("all")){
                System.out.println(i.getName());
            }
        }
    }
    static class Music{
        String type;
        String name;
        String time;

        public Music(String type, String name, String time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
