package inout;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileRunner {

    public static void main(String[] args) throws IOException {
        File file = new File("c:/projects/groovy-gradle-starter/src/main/resources/files/inoutFile.txt");
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.canExecute());
        System.out.println(file.getAbsolutePath());

        File newDir = new File("/resources/files/testDir/mktestDir");
//        System.out.println(newDir.mkdirs());
//        System.out.println(newDir.getAbsolutePath());
//        System.out.println(newDir.delete());
//        System.out.println(newDir.exists());

        File dir = new File("c:/projects/groovy-gradle-starter/src/main/resources");
        System.out.println(Arrays.toString(dir.list()));
    }
}
