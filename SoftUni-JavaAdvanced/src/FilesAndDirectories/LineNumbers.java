package FilesAndDirectories;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))){

            String line = bufferedReader.readLine();
            int n = 1;
            while (line!=null){
                printWriter.printf("%d. %s\n", n++, line);
                line = bufferedReader.readLine();
            }
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
