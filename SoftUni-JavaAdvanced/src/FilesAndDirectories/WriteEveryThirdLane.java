package FilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLane {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\input.txt";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\output.txt";

        FileReader fileReader = new FileReader(inputPath);
        FileWriter fileWriter = new FileWriter(outputPath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        int lineCounter = 1;
        String line = bufferedReader.readLine();
        while (line!=null){
            if(lineCounter%3==0){
                printWriter.println(line);
            }
            line = bufferedReader.readLine();
            lineCounter++;
        }
        printWriter.close();
    }
}
