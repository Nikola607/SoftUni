package FilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        InputStream in = new FileInputStream(inputPath);
        OutputStream out = new FileOutputStream(outputPath);

        int oneByte = in.read();
        while (oneByte >= 0) {
            if (!symbols.contains((char) oneByte)) {
                out.write((char)oneByte);
            }
            oneByte = in.read();
        }
    }
}
