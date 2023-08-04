package inout;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FilesExamples {
    public static void main(String[] args) throws IOException {
//        Files.copy(pathFrom, pathTo);
//        Files.delete(path);
        Path path = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/copyOutData.txt");
        Files.lines(path).forEach(System.out::println);

        Path pathDir = Path.of("/projects/groovy-gradle-starter/src/main/resources/files");
//        Files.list(pathDir).forEach(System.out::println);
        Files.walk(pathDir).forEach(System.out::println);

        Path pathScanner = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/scanner.txt");
        //Files.copy(path, pathScanner);

        Scanner scanner = new Scanner(pathScanner);
//            scanner.findInLine(Pattern.compile("nn|ll")).;
    }
}
