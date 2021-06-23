package FilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        FileInputStream fileStream = new FileInputStream(path);
        int oneByte = fileStream.read();
        while (oneByte >= 0) {
            System.out.printf("%s ",Integer.toBinaryString(oneByte));
            oneByte = fileStream.read();
        }
    }
}
