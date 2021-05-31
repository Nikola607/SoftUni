package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {

        String path = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
           String line = bufferedReader.readLine();

            while (line != null) {
                int sumOfLine = 0;

                for(int i = 0; i<line.length(); i++){
                    char currentSymbol = line.charAt(i);
                    sumOfLine+=currentSymbol;
                }
                System.out.println(sumOfLine);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
