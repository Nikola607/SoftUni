package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {

        String path = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            int sum = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentSymbol = line.charAt(i);

                    sum += currentSymbol;
                }
                line = bufferedReader.readLine();
            }
            System.out.println(sum);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
