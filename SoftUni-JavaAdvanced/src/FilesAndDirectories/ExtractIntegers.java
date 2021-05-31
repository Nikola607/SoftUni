package FilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";
        Scanner scan =  new Scanner(new FileInputStream(inputPath));

        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        while (scan.hasNext()){
            if(scan.hasNextInt()){
                writer.println(scan.nextInt());
            }
            scan.next();
        }
        writer.close();
    }
}
