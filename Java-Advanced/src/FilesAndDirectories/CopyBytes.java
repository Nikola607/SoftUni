package FilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";
        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int oneByte = inputStream.read();

        while (oneByte >= 0) {
            if(oneByte==10 || oneByte==32){
                outputStream.write(oneByte);
            }else {
                String stringByte = String.valueOf(oneByte);
                for (int i = 0; i < stringByte.length(); i++) {
                    outputStream.write(stringByte.charAt(i));
                }
            }
            oneByte = inputStream.read();
        }
    }
}
