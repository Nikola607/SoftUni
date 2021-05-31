package Exercises;

import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(", ");
        Commands commands = new Commands(words[0], words[1], words[2]);
        int n = Integer.parseInt(scan.nextLine());

        for(int i = 0; i<n; i++){
            String[] commandArray = scan.nextLine().split(": ");
            switch (commandArray[0]){
                case"Edit":
                    commands.setContent(commandArray[1]);
                    break;
                case"ChangeAuthor":
                    commands.setAuthor(commandArray[1]);
                    break;
                case"Rename":
                    commands.setTitle(commandArray[1]);
                    break;
            }
        }
        System.out.println(commands.toString());
    }

    static class Commands {
        String title;
        String content;
        String author;

        public Commands(String edit, String content, String author) {
            this.title = edit;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
        public  String toString(){
        return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }
}
