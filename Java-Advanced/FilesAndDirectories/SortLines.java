package FilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";

        try{
            List<String> list = Files.readAllLines(Paths.get(inputPath));
            list = list.stream().filter(a-> !a.isBlank()).collect(Collectors.toList());
            Collections.sort(list);
            Files.write(Paths.get(outputPath), list);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
