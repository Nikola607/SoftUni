package FilesAndDirectories;

import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {

        String firstPath = "C:\\\\Users\\\\wolte\\\\IdeaProjects\\\\JavaAdvanced\\\\src\\\\FilesAndDirectories\\\\inputOne.txt";
        String secondPath = "C:\\\\Users\\\\wolte\\\\IdeaProjects\\\\JavaAdvanced\\\\src\\\\FilesAndDirectories\\\\inputTwo.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";

        try (BufferedReader firstReader = new BufferedReader(new FileReader(firstPath));
             BufferedReader secondReader = new BufferedReader(new FileReader(secondPath));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))) {

            String lineOne = firstReader.readLine();
            while (lineOne != null) {
                printWriter.println(lineOne);
                lineOne = firstReader.readLine();
            }

            String lineTwo = secondReader.readLine();
            while (lineTwo != null) {
                printWriter.println(lineTwo);
                lineTwo = secondReader.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
