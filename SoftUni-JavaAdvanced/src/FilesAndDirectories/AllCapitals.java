package FilesAndDirectories;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))) {

            String line = bufferedReader.readLine();

            while (line!=null){
               line = line.toUpperCase();

               printWriter.println(line);
               line = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
