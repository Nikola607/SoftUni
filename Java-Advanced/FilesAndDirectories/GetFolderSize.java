package FilesAndDirectories;

import java.io.*;

public class GetFolderSize {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\Exercises Resources";
        String outputPath = "C:\\Users\\wolte\\IdeaProjects\\JavaAdvanced\\src\\FilesAndDirectories\\results.txt";

        try(PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))){

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            int size = 0;
            if(files!=null) {
                for (File file : files) {
                    size += file.length();
                }
            }
            printWriter.print("Folder size: " + size);
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
