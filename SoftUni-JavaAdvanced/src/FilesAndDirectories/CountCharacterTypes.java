package FilesAndDirectories;

import java.io.*;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> symbols = Set.of('.', ',', '!', '?');

        int vowelsCount = 0;
        int symbolsCount = 0;
        int consonantsCount = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))){

            String line = bufferedReader.readLine();
            while (line!=null){
                for(int i = 0; i<line.length(); i++){
                    char currentSymbol = line.charAt(i);

                    if(vowels.contains(currentSymbol)){
                        vowelsCount++;
                    }else if(symbols.contains(currentSymbol)){
                        symbolsCount++;
                    }else if(currentSymbol !=' '){
                        consonantsCount++;
                    }
                }
                line = bufferedReader.readLine();
            }
            printWriter.println("Vowels: " + vowelsCount);
            printWriter.println("Consonants: " + consonantsCount);
            printWriter.println("Punctuation: " + symbolsCount);
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
