package FilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {

       String path = ("C:\\Users\\wolte\\Desktop\\Files-and-Streams");
       File root = new File(path);

        Deque<File> deq = new ArrayDeque<>();
        deq.offer(root);

        int counter = 0;
        while (!deq.isEmpty()){
            File current = deq.poll();
            File[] nestedFiles = current.listFiles();
            for(File file : nestedFiles){
                if(file.isDirectory()){
                    deq.offer(file);
                }
            }
            System.out.println(current.getName());
            counter++;
        }
        System.out.println(counter + " folders");
    }
}
