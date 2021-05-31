package Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Commands> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            String[] data = scan.nextLine().split(", ");
            Commands commands = new Commands(data[0], data[1], data[2]);
            list.add(commands);

        }
        String action = scan.nextLine();
        switch (action){
            case"title":
                list.sort(Comparator.comparing(Commands::getTitle));
                break;
            case"content":
                list.sort(Comparator.comparing(Commands::getContent));
                break;
            case"author":
                list.sort(Comparator.comparing(Commands::getAuthor));
                break;
        }
        list.stream()
        .forEach(commands -> System.out.println(commands.toString()));
    }
    static class Commands{
        String title;
        String content;
        String author;

        public Commands(String title, String content, String author) {

            this.title = title;
            this.content = content;
            this.author = author;
        }
        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }
        public String toString(){
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }
}