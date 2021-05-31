package FilesAndDirectories;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {

        String wordPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\words.txt";
        String textPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\text.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\results.txt";

        try (BufferedReader wordReader = new BufferedReader(new FileReader(wordPath));
             BufferedReader textReader = new BufferedReader(new FileReader(textPath));
             PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))) {

            String[] words = wordReader.readLine().split("\\s+");
            String[] text = textReader.readLine().split("\\s+");
            Map<String, Integer> map = new LinkedHashMap<>();

            map.put(words[0], 0);
            map.put(words[1], 0);
            map.put(words[2], 0);

            for (String currentWord : text) {
                if (currentWord.equals(words[0])) {
                  map.put(currentWord, map.get(currentWord) + 1);

                } else if (currentWord.equals(words[1])) {
                    map.put(currentWord, map.get(currentWord) + 1);

                } else if (currentWord.equals(words[2])) {
                    map.put(currentWord, map.get(currentWord) + 1);

                }
            }

            map.entrySet().stream().
                    sorted((a, b) -> b.getValue().compareTo(a.getValue())).
                    forEach(e -> printWriter.println(e.getKey() + " - " + e.getValue()));

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
