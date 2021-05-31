package TextProccesing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        String file = path.substring(path.lastIndexOf("\\") + 1);

        String name = file.substring(0, file.indexOf("."));
        String extension = file.substring(file.indexOf(".") + 1);

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);

    }
}
